package app;

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
            if (nro == e.nroEpisodio) {
                return e;
            }

        }
        return null;
    }

    public Episodio getNombreEpisodio(String nombre) {

        for (Episodio n : this.episodios) {
            if (nombre.equals(n.nombreEpisodio)) {
                return n;
            }

        }
        return null;
    }
}
