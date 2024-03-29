package app;

import java.util.*;

public class App {

    public static Scanner Teclado = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Para agregar una persona presione 1.");
        System.out.println("Para eliminar una persona presione 2.");
        System.out.println("Para modificar una persona presione 3.");
        System.out.println("Para ver el listado presione 4.");

        int opcion = Teclado.nextInt();
        Teclado.nextLine();

        while (opcion > 0) {

            switch (opcion) {
            case 1:
                alta();
                break;

            case 2:
                baja();
                break;

            case 3:
                modifica();
                break;

            case 4:
                listar();
                break;

            default:
                System.out.println("La opcion no es correcta.");
                break;
            }

            System.out.println("Para agregar una persona presione 1.");
            System.out.println("Para eliminar una persona presione 2.");
            System.out.println("Para modificar una persona presione 3.");
            System.out.println("Para ver el listado presione 4.");

            opcion = Teclado.nextInt();
            Teclado.nextLine();
        }

    }

    public static void alta() {
        Persona p = new Persona();
        System.out.println("Ingrese el nombre:");
        p.nombre = Teclado.nextLine();
        System.out.println("Ingrese el DNI:");
        p.dni = Teclado.nextInt();
        Teclado.nextLine();
        System.out.println("Ingrese la edad:");
        p.edad = Teclado.nextInt();
        Teclado.nextLine();
        ABM.Personas.add(p);
    }

    public static void baja() {
        System.out.println("Ingrese el nombre:");
        String n = Teclado.nextLine();
        System.out.println("Ingrese el DNI:");


        Persona pEncontrado = null;

        for (Persona p : ABM.Personas) {
           if(p.nombre.equals(n)){
               pEncontrado = p;
           }
        }
        ABM.Personas.remove(pEncontrado);

    }

    public static void modifica() {
        System.out.println("Ingrese el nombre:");
        String n = Teclado.nextLine();

        for (Persona pe : ABM.Personas) {
            if (n.equals(pe.nombre)) {
                System.out.println("Ingrese el nuevo nombre:");
                String nombre = Teclado.nextLine();
                pe.setNombre(nombre);
                System.out.println("Ingrese el DNI");
                int numero = Teclado.nextInt();
                Teclado.nextLine();
                pe.setDni(numero);
                System.out.println("Ingrese la nueva edad");
                int edad = Teclado.nextInt();
                Teclado.nextLine();
                pe.setEdad(edad);
            
            }
        }

    }

    public static void listar() {
        for (int i = 0; i < ABM.Personas.size(); i++) {
            System.out.println(ABM.Personas.get(i));
        }
    }
   
}

