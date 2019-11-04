package ar.com.ada.mongo.netfly.controllers;

import ar.com.ada.mongo.netfly.models.request.PeliculaRequest;
import ar.com.ada.mongo.netfly.models.response.PeliculaResponse;
import ar.com.ada.mongo.netfly.services.PeliculaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * PeliculaController
 */
@RestController
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;

    @PostMapping("/peliculas")
    public PeliculaResponse postRegistrarPelicula(@RequestBody PeliculaRequest req) {

        PeliculaResponse p = new PeliculaResponse();

        peliculaService.registrarPelicula(req.titulo, req.genero, req.director, req.anio, req.ganoOscar);

        p.message= "Pelicula registrada con exito";

        return p;
    }
    
}