package ar.com.ada.mongo.netfly.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Contenido
 */
public class Temporada {

    public int nroTemporada;
    public List<Episodio> episodios = new ArrayList<Episodio>();

    public Episodio getNumeroEpisodio(int nro) {
        for (Episodio e : this.episodios) {
            if (e.nroEpisodio == nro) {
                return e;
            }

        }
        return null;
    }

    public Episodio getTituloEpisodio(String titulo) {

        for (Episodio e : this.episodios) {
            if (titulo.equals(e.titulo)) {
                return e;
            }

        }
        return null;
    }
}
