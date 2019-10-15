package ar.com.ada.api.billeteravirtual.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Cuenta;
import ar.com.ada.api.billeteravirtual.repo.CuentaRepository;

/**
 * CuentaService
 */
@Service
public class CuentaService {

    @Autowired
    CuentaRepository repo;

    public List<Cuenta> getCuentas() {
        return repo.findAll();
    }
 
    public void save(Cuenta c){
        repo.save(c);
    }
 
}