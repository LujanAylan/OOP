package ar.com.ada.api.billeteravirtual.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;

/**
 * BilleteraController
 */
@RestController
public class BilleteraController {

    @Autowired
    BilleteraService billeteraService;

    @GetMapping("/billeteras")
    public List<Billetera> getBilleteras(){

        List<Billetera> b = billeteraService.getBilleteras();
        return b;
    }

    /*
    @GetMapping("/billeteras/{id}/saldos")
    public Billetera GetBilleteraById(@PathVariable int id)
    {
    }

    @GetMapping("/billeteras/{id}/movimientos")
    public Billetera GetBilleteraById(@PathVariable int id)
    {
    }

    @PostMapping("/billeteras/{id}/cuentas/{idC}")
    public Billetera GetBilleteraById(@PathVariable int id)
    {
    }

    @PostMapping("/billeteras/{id}/usuarios/{idU}")

    @PostMapping("/billeteras/{id}/billeteras/{idB}")
    */
}