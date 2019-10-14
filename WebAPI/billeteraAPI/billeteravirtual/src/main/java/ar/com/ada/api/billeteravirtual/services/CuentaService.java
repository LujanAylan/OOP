package ar.com.ada.api.billeteravirtual.services;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.api.billeteravirtual.entities.Cuenta;

/**
 * CuentaService
 */
public class CuentaService {

    @Autowired
    CuentaService cuentaService;
 
    public void save(Cuenta c){
        cuentaService.save(c);
    }
 
}