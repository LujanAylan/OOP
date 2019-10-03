package app;

/**
 * Cine
 */
public class Cine {

    //Atributos
    private Sala sala;
    private double precio;
    private Pelicula pelicula;
 
    //Constructor
    public Cine(Sala sala, double precio, Pelicula pelicula) {
        this.sala = sala;
        this.precio = precio;
        this.pelicula = pelicula;
    }
 
    public double getPrecio() {
        return precio;
    }
 
    public void setPrecio(double precio) {
        this.precio = precio;
    }
 
    public Pelicula getPelicula() {
        return pelicula;
    }
 
    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    /**
     * Indicamos si el espectador cumple lo necesario para entrar: Tiene
     * dinero, edad y si hay lugar.
     * @param e
     * @return
     */
    public boolean sePuedeSentar(Espectador e) {
        return e.tieneDinero(precio) && e.tieneEdad(pelicula.getEdadMinima());
    }
 
    /**
     * Mostramos la información de nuestro cine 
     */
    public void mostrar() {
 
        System.out.println("Información cine");
        System.out.println("Pelicula reproducida: " + pelicula);
        System.out.println("Precio entrada: " + precio);
    }
    
}