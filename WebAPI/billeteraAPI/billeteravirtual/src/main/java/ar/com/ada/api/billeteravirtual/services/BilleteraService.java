package ar.com.ada.api.billeteravirtual.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 */
public class BilleteraService {

    @Autowired
    BilleteraRepository repo;

    public List<Billetera> getBilleteras(){
        return repo.findAll();
    }

    public Billetera agregarDinero(){
        return null;
    }

    public Billetera transferirDinero(){
        return null;
    }

}