package ar.com.ada.api.billeteravirtual.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.billeteravirtual.entities.*;
import ar.com.ada.api.billeteravirtual.models.request.DepositRequest;
import ar.com.ada.api.billeteravirtual.models.request.MovimientoRequest;
import ar.com.ada.api.billeteravirtual.models.response.DepositoResponse;
import ar.com.ada.api.billeteravirtual.models.response.MovimientoResponse;
import ar.com.ada.api.billeteravirtual.models.response.SaldoResponse;
import ar.com.ada.api.billeteravirtual.services.BilleteraService;

/**
 * BilleteraController
 */
@RestController
public class BilleteraController {

    @Autowired
    BilleteraService billeteraService;

    @GetMapping("/billeteras/{id}/saldos")
    public ArrayList<SaldoResponse> getBilleteraById(@PathVariable int id) {

        Billetera b = billeteraService.buscarPorId(id);

        ArrayList<SaldoResponse> ls = new ArrayList<>();
        for (Cuenta c : b.getCuentas()) {
            SaldoResponse s = new SaldoResponse();
            s.IdBilletera = id;
            s.moneda = c.getMoneda();
            s.saldo = c.getSaldo();
            ls.add(s);
        }
        return ls;
    }

    @PostMapping("/billeteras/{id}/depositos")
    public DepositoResponse setBilleteraById(@PathVariable int id, @RequestBody DepositRequest req) {

        Billetera b = billeteraService.buscarPorId(id);
        billeteraService.agregarPlata(b, req.importeADepositar, req.moneda, req.concepto, req.detalle);
        billeteraService.save(b);

        DepositoResponse r = new DepositoResponse();
        r.isOk = true;
        r.message = "Deposito con exito";

        return r;
    }

    @PostMapping("/billeteras/{id}/traferencias/")
    public MovimientoResponse postBilleteraTransferir(@PathVariable int id, @RequestBody MovimientoRequest req){
        Billetera bOrigen = billeteraService.buscarPorId(id);
        billeteraService.transferencia(bOrigen, req.email, req.importe, req.moneda, 
        req.conceptoOperacion, req.detalle);

        billeteraService.save(bOrigen);

        MovimientoResponse r = new MovimientoResponse();
        r.isOk = true;
        r.message = "Transferencia con exito";

        return r;
    }

    @GetMapping("/billetera/{id}/movimientos/{moneda}")
    public ArrayList<MovimientoResponse> getBilleterById(@PathVariable int id, @PathVariable String moneda,
            @RequestParam(value = "orderByFech", required = false) boolean orderByFecha) {

        
        ArrayList<MovimientoResponse> lm = new ArrayList<>();
        if (orderByFecha) {
            List<Movimiento> lmOrdenado = billeteraService.buscarMovOrdenados(id, moneda);
            for (Movimiento mov : lmOrdenado) {
                MovimientoResponse m = new MovimientoResponse();
                m.movimientoId = id;
                m.fechaMovimiento = mov.getFecha();
                m.importe = mov.getImporte();
                m.conceptoOperacion = mov.getConceptoOperacion();
                lm.add(m);
            }
            return lm;
        }

        Billetera b = billeteraService.buscarPorId(id);
        Cuenta c = billeteraService.buscarCuentaPorMoneda(b, moneda);
        for (Movimiento mov : c.getMovimientos()) {
            MovimientoResponse m = new MovimientoResponse();
            m.movimientoId = id;
            m.fechaMovimiento = mov.getFecha();
            m.importe = mov.getImporte();
            m.conceptoOperacion = mov.getConceptoOperacion();
            lm.add(m);
        }
        return (lm);
    }
}