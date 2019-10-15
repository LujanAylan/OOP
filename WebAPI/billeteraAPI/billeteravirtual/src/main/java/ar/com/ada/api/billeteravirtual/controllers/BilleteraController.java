package ar.com.ada.api.billeteravirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.models.request.MovimientoRequest;
import ar.com.ada.api.billeteravirtual.models.response.MovimientoResponse;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;

/**
 * BilleteraController
 */
@RestController
public class BilleteraController {

    @Autowired
    BilleteraService billeteraService;

    @GetMapping("/billeteras/{id}")
    public Billetera getBilleteraById(@PathVariable int id) {

        Billetera b = billeteraService.buscarPorId(id);
        return b;
    }

    @PostMapping("/billeteras/transferencias")
    public MovimientoResponse transferencia(@RequestBody MovimientoRequest req){
        MovimientoResponse r = new MovimientoResponse();

        billeteraService.transferirDinero(req.importe, req.billeteraId, req.conceptoOperacion, req.tipoOperacion);
        r.message = "La transferencia se ha realizado con éxito";
        return r;
        
    }

    @GetMapping("/billeteras/{id}/saldo")
    public double getSaldo(@PathVariable int id) {

        double b = billeteraService.getSaldo(id);
        return b;
    }

    @GetMapping("/billeteras/{id}/saldoDisponible")
    public double getSaldoDisponible(@PathVariable int id) {

        double b = billeteraService.getSaldoDisponible(id);
        return b;
    }

}