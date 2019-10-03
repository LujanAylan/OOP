package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Serie
 */
public class Serie extends Contenido {
    
    public static final String Pooflix = null;
	public List<Temporada> temporadas = new ArrayList<Temporada>();

	public Temporada getTemporada(int nro) {

        for (Temporada t : this.temporadas) {

            if (nro == t.nroTemporada) {
                return t;
            }
        }
        return null;
    }


}