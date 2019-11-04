package ar.com.ada.mongo.netfly.entities;

/**
 * Episodio
 */
public class Episodio{

    public int nroEpisodio;
    public String titulo;
    public int duracion;

    public Episodio (String titulo){
        this.titulo = titulo;
    }

    public void reproducir() {

        System.out.println("Reproduciendo " + this.titulo + " de la temporada de Websodios");
    }
}