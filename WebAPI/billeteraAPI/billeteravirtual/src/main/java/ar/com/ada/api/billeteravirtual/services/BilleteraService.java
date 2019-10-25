package ar.com.ada.api.billeteravirtual.services;

import java.math.BigDecimal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.entities.Usuario;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;
import ar.com.ada.api.billeteravirtual.repo.MovimientoRepository;

/**
 * BilleteraService
 */
@Service
public class BilleteraService {

    @Autowired
    BilleteraRepository repo;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    MovimientoRepository movRepo;

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

    public Billetera buscarBilletera(Usuario usuario){
        Billetera b=  usuario.getPersona().getBilletera();
        return b;

    }

    public void agregarPlata(Billetera billetera, BigDecimal plata, 
    String moneda, String concepto, String detalle) {
        billetera.agregarPlata(plata, moneda, concepto, detalle);

    }

    public void descontarPlata(Billetera billetera, BigDecimal plata, String moneda,
    String concepto, String detalle) {
        billetera.descontarPlata(plata, moneda, concepto, detalle);
    }

    public void transferencia (Billetera deBilletera, String email ,BigDecimal plata, 
    String moneda, String concepto, String detalle){
        Billetera aBilletera;

        aBilletera = usuarioService.buscarPorEmail(email).getPersona().getBilletera();
        deBilletera.transferencia(aBilletera, plata, moneda, concepto, detalle);
    }

    public Cuenta buscarCuentaPorMoneda(Billetera b, String moneda){
        for (Cuenta cuenta : b.getCuentas()) {
            if (cuenta.getMoneda().equals(moneda)) {
                return cuenta;   
            }
        }
        return null;
    }

    public List <Movimiento> buscarMovOrdenados (int billeteraId,String moneda){
        return movRepo.FindOrderByFecha(billeteraId,moneda);
    }

}