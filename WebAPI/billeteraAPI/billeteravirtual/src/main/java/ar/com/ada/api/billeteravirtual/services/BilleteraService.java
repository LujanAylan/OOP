package ar.com.ada.api.billeteravirtual.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 */
@Service
public class BilleteraService {

    @Autowired
    BilleteraRepository repo;

    @Autowired
    UsuarioService usuarioService;

    public void save(Billetera b){
        repo.save(b);
    }

    public Billetera buscarPorId(int id) {

       Optional<Billetera> b = repo.findById(id);

       if (b.isPresent()) {
           return b.get();
       }
       return null;
    }

    public double getSaldo(int id) {
        Optional<Billetera> b = repo.findById(id);

        if (b.isPresent()){
            Cuenta c = b.get().getCuenta(0);
          
            return c.getSaldo();
        }
        return id;

    }
    public double getSaldoDisponible(int id) {
        Optional<Billetera> b = repo.findById(id);

        if (b.isPresent()){
            Cuenta c = b.get().getCuenta(0);
          
            return c.getSaldoDisponible();
        }
        return id;
    }

    public Billetera buscarBilletera(Usuario usuario){
        Billetera b=  usuario.getPersona().getBilletera();

        return b;
    }
    
    public void transferirDinero(double importe, int id, String conceptoDeOperacion, String tipoDeOperacion) {

        Usuario usuarioDestino = usuarioService.buscarPorId(id);
        Usuario usuarioOrigen = usuarioService.buscarPorId(id);

        Billetera billeteraOrigen = buscarBilletera(usuarioOrigen);

        Movimiento transferencia = new Movimiento();
        transferencia.setImporte(-(importe));
        transferencia.setDeUsuario(usuarioOrigen.getUsuarioId());
        transferencia.setaUsuario(usuarioDestino.getUsuarioId());
        transferencia.setCuentaDestino(usuarioDestino.getPersona().getBilletera().getBilleteraId());
        transferencia.setCuentaOrigen(usuarioOrigen.getPersona().getBilletera().getBilleteraId());
        transferencia.setConceptoOperacion(conceptoDeOperacion);
        transferencia.setFecha(new Date());
        transferencia.setEstado(0);
        transferencia.setTipoOperacion("Transferencia");
        
        usuarioOrigen.getPersona().getBilletera().agregarMovimiento(transferencia);
        repo.save(usuarioOrigen.getPersona().getBilletera());

        Movimiento recibirDinero = new Movimiento();
        recibirDinero.setImporte(importe);
        recibirDinero.setDeUsuario(billeteraOrigen.getPersona().getUsuario().getUsuarioId());
        recibirDinero.setaUsuario(usuarioDestino.getUsuarioId());
        recibirDinero.setCuentaDestino(usuarioDestino.getPersona().getBilletera().getBilleteraId());
        recibirDinero.setCuentaOrigen(billeteraOrigen.getBilleteraId());
        recibirDinero.setConceptoOperacion("Regalo");
        recibirDinero.setFecha(new Date());
        recibirDinero.setEstado(0);
        recibirDinero.setTipoOperacion("Transferencia");

        usuarioDestino.getPersona().getBilletera().agregarMovimiento(recibirDinero);
        repo.save(usuarioDestino.getPersona().getBilletera());
    }

}