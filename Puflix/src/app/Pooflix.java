package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Netflix
 */
public class Pooflix {

    public static List<Pelicula> CatalogoPeliculas = new ArrayList<Pelicula>();
    public static List<Serie> CatalogoSeries = new ArrayList<Serie>();

    public static Pelicula buscarPelicula(String nombre) {

        for (Pelicula p : Pooflix.CatalogoPeliculas) {
            if (nombre.equals(p.nombre)) {
                return p;

            }

        }
        return null;
    }

    public static Serie buscaSerie(String nombre){

        for (Serie se : Pooflix.CatalogoSeries) {
            if(nombre.equals(se.nombre)){
                return se;
            }
            
        }return null;

    }

    public static void limpiarCatalogo() {
        Pooflix.CatalogoPeliculas.clear();
        Pooflix.CatalogoSeries.clear();
    }

    public static void InicializarCatalogo() {
        Pooflix.agregarTheGoodPlace();
    }

  
    public static void agregarTheGoodPlace(){
        Serie ww = new Serie();
        ww.nombre = "The Good Place";
        ww.genero = "Comedia";
        ww.anio = 2016;

        Temporada t1 = new Temporada();
        t1.nroTemporada = 1;
    
        Temporada tw = new Temporada();
        tw.nroTemporada = 2;

        Episodio epi = new Episodio("Everything Is Fine");
        epi.duracion = 43;
        epi.nroEpisodio = 1;

        t1.episodios.add(epi);

        epi = new Episodio("Flying");
        epi.duracion = 40;
        epi.nroEpisodio = 2;

        t1.episodios.add(epi);

        epi = new Episodio("Tahani Al-Jamil");
        epi.duracion = 41;
        epi.nroEpisodio = 3;

        t1.episodios.add(epi);

        epi = new Episodio("Jason Mendoza");
        epi.duracion = 45;
        epi.nroEpisodio = 4;

        t1.episodios.add(epi);

        epi = new Episodio("Category 55 Emergency Doomsday Crisis");
        epi.duracion = 43;
        epi.nroEpisodio = 5;
        t1.episodios.add(epi);

        epi = new Episodio("What We Owe to Each Other");
        epi.duracion= 42;
        epi.nroEpisodio = 6;

        t1.episodios.add(epi);

        epi = new Episodio("The Eternal Shriek");
        epi.duracion= 41;
        epi.nroEpisodio = 7;

        t1.episodios.add(epi);

        epi = new Episodio("Most Improved Player");
        epi.duracion= 40;
        epi.nroEpisodio = 8;

        t1.episodios.add(epi);

        epi = new Episodio("...Someone Like Me as a Member");
        epi.duracion= 42;
        epi.nroEpisodio = 9;

        t1.episodios.add(epi);

        epi = new Episodio("Chidi's Choice");
        epi.duracion= 44;
        epi.nroEpisodio = 10;
        
        t1.episodios.add(epi);

        Websodio w1 = new Websodio("Websodio 1");
        w1.nroEpisodio = 1;
        w1.duracion = 15;

        tw.episodios.add(w1);

        Websodio w2 = new Websodio("Websodio 2");
        w2.nroEpisodio = 2;
        w2.duracion = 15;

        tw.episodios.add(w2);

        tgd.temporadas.add(t1);
        tgd.temporadas.add(tw);

        Pooflix.CatalogoSeries.add(tgd);
        
    }

}
