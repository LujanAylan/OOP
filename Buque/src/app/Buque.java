package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Buque
 */
public class Buque {

    public List<Contenedor> losContenedores = new ArrayList<Contenedor>();

    public String nombre;

    public int calcularPeso() {
        int suma = 0;

        for (Contenedor c : losContenedores) {
            suma = suma + c.peso;
        }
        return suma;

    }

    public Contenedor getContenedorMaximo() {

        Contenedor maxCont = null;
        int maxPeso;
        maxPeso = 0;

        for (Contenedor c : losContenedores) {
            if (c.peso > maxPeso) {
                maxPeso = c.peso;
                maxCont = c;
            }
        }

        return maxCont;

    }

    public static Buque NuevoBuqueCargado() {

        Buque barco = new Buque();

        barco.nombre = "Ada Express";

        barco.losContenedores = new ArrayList<Contenedor>();

        for (int i = 1; i <= 100; i++) {

            Contenedor c = new Contenedor();

            c.iDContenedor = i + 3000;

            c.peso = 7 * i;

            c.puertoArribo = new Puerto();
            c.puertoArribo = Puerto.BuscaPuerto((i % 3) + 1);

            barco.losContenedores.add(c);

        }

        return barco;

    }
}