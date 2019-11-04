package ar.com.ada.mongo.netfly.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Serie
 */
@Document(collection = "Series")
public class Serie extends Contenido {

	public List<Temporada> temporadas = new ArrayList<Temporada>();

	public Temporada getTemporada(int nro) {

        for (Temporada t : this.temporadas) {

            if (t.nroTemporada == nro) {
                return t;
            }
        }
        return null;
    }

}