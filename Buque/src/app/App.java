package app;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Inicializando Buques y Puertos");

        Buque barquito = Buque.NuevoBuqueCargado();

        for (Contenedor contenedorcito : barquito.losContenedores) {

            switch (contenedorcito.puertoArribo.nroPuerto) {
            case 1:
                Puerto.BuscaPuerto(1).ContenedoresRecibidos.add(contenedorcito);
                break;
            case 2:
                Puerto.BuscaPuerto(2).ContenedoresRecibidos.add(contenedorcito);
                break;

            case 3:
                Puerto.BuscaPuerto(3).ContenedoresRecibidos.add(contenedorcito);
                break;

            default:
                break;
            }
        }

        for (Puerto puertito : Puerto.PuertosDelMundo) {

            System.out.println("El puerto "+ puertito.nombre + " recibirá " + puertito.ContenedoresRecibidos.size()+" contenedores");

        }

        System.out.println("El peso del barco " + barquito.nombre + "es : "+ barquito.calcularPeso());

        Contenedor elContenedorMasPesado = barquito.getContenedorMaximo();
        
        System.out.println("El contenedor mas pesado es "+ elContenedorMasPesado.iDContenedor + " cuyo peso es: " + elContenedorMasPesado.peso);

    }
}