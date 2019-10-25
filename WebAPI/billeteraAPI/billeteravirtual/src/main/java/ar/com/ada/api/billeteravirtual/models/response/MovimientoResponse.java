package ar.com.ada.api.billeteravirtual.models.response;

import java.math.BigDecimal;
import java.util.*;

/**
 * MovimientoResponse
 */
public class MovimientoResponse {

    public boolean isOk = false;
    public String message = "";
    public String email;
    public int movimientoId;
    public Date fechaMovimiento;
    public BigDecimal importe;
    public String conceptoOperacion;
}