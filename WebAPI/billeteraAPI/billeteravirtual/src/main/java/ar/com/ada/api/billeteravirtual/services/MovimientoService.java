package ar.com.ada.api.billeteravirtual.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Movimiento;
import ar.com.ada.api.billeteravirtual.repo.MovimientoRepository;

/**
 * MovimientoService
 */
@Service
public class MovimientoService {

    @Autowired
    MovimientoRepository repo;

    public List<Movimiento> buscarMovimientosOrdenadoPorFecha() {
        return repo.findAllOrderByFecha();
    }
    
    public List<Movimiento> getMovimientos() {
        return repo.findAll();
    }

    public void save(Movimiento m){
        repo.save(m);
    }
    
}