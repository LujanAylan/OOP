package app;

public class App {
    public static void main(String[] args) throws Exception {

        Cuenta nuevaPersona = new Cuenta("Jose", 500);

        nuevaPersona.setTitular(" ");

        System.out.println(nuevaPersona.getTitular());

        nuevaPersona.ingresarCantidad(500);
        nuevaPersona.ingresarCantidad(250);

        nuevaPersona.retirarCantidad(120);

        System.out.println(nuevaPersona);

    }
}