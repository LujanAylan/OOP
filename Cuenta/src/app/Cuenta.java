package app;

/**
 * Cuenta
 */
public class Cuenta {

    private String titular;
    private double cantidad;

    public Cuenta(String titular) {

       this(titular, 0);
    
    }

    public Cuenta(String titular, double cantidad) {
    
        this.titular = titular;
    
        if (cantidad < 0) {
            this.cantidad = 0;
        } 
        else {
            this.cantidad = cantidad;
        }

    }

    public String getTitular() {
        return titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setTitular(String titular) {

        if (titular.equals(" ")) {
            return;

        }

        this.titular = titular;
    }

    public void setCantidad(double cantidad) {

        if (cantidad < 0) {
            return;
        } 
        else {
            this.cantidad = cantidad;
        }

    }

    public void ingresarCantidad(double cantidad) {

        if (cantidad < 0) {
            return;
        } 
        else {
            this.cantidad += cantidad;
        }

    }

    public void retirarCantidad(double cantidad) {

        if (this.cantidad - cantidad < 0) {
            this.cantidad = 0;
        } 
        else {
            this.cantidad -= cantidad;
        }

    }

    public String toString() {

        return "El titular " + titular + " tiene: "+ cantidad + " pesos";
    
    }
}