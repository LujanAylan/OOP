package ar.com.ada.api.billeteravirtual.models.request;

import java.math.BigDecimal;

/**
 * MovimientoRequest
 */
public class MovimientoRequest {

    public BigDecimal importe;
    public String tipoOperacion;
    public String conceptoOperacion;
    public String detalle;
    public String moneda;
	public String email;
}