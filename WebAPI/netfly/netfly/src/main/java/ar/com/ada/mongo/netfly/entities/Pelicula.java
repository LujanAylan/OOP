package ar.com.ada.mongo.netfly.entities;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Pelicula
 */
@Document(collection = "Peliculas")
public class Pelicula extends Contenido {

    public boolean ganoOscar;

    public boolean isGanoOscar() {
        return ganoOscar;
    }

    public void setGanoOscar(boolean ganoOscar) {
        this.ganoOscar = ganoOscar;
    }
    
}