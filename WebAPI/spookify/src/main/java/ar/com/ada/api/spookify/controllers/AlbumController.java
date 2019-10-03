package ar.com.ada.api.spookify.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.spookify.entities.Album;
import ar.com.ada.api.spookify.entities.Cancion;

/**
 * AlbumController
 */
@RestController
public class AlbumController {

    @GetMapping(value = "/albumes") 
    public List<Album> getAlbum(){

        List<Album> albumes = new ArrayList<Album>();
        List<Cancion> canciones = new ArrayList<Cancion>();
        Cancion c = new Cancion();
        
        Album a = new Album();
        a.setArtista("Lorde");
        a.setAlbum("Pure Heroine");
        c.setTitulo("Tennis Court");
        c.setDuracion(3.18);
        canciones.add(c);

        c = new Cancion();
        c.setTitulo("Ribs");
        c.setDuracion(4.18);
        canciones.add(c);

        c = new Cancion();
        c.setTitulo("400 Lux");
        c.setDuracion(3.54);
        canciones.add(c);

        a.setCanciones(canciones);
        
        albumes.add(a);

        canciones = new ArrayList<Cancion>(); 
        
        a = new Album();
        a.setArtista("Oasis");
        a.setAlbum("Definitely Maybe");

        c = new Cancion();
        c.setTitulo("Up in the sky");
        c.setDuracion(4.28);
        canciones.add(c);

        c = new Cancion();
        c.setTitulo("Slide Away");
        c.setDuracion(6.32);
        canciones.add(c);
        a.setCanciones(canciones);

        albumes.add(a);

        return albumes;

    }
    
}