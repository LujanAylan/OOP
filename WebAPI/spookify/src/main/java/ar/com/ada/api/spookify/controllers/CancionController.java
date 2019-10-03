package ar.com.ada.api.spookify.controllers;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.spookify.entities.Cancion;
/**
* CancionController
*/
@RestController
public class CancionController {

    @GetMapping( value = "/temas")

    public List<Cancion> getTodas(){

    List<Cancion> list = new ArrayList<Cancion>();
    Cancion c = new Cancion ();
    c.setTitulo ("Goodmorning");
    c.setDuracion (4.0);

    list.add(c);
    
    c = new Cancion ();
    c.setTitulo ("Dont take the money");
    c.setDuracion (3.5);
    
    list.add(c);
    
    return list;

    }
}