package ar.com.ada.mongo.netfly.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.mongo.netfly.entities.Pelicula;

/**
 * PeliculaRepository
 */
@Repository
public interface PeliculaRepository extends MongoRepository<Pelicula, ObjectId>{
    Pelicula findByTitulo(String titulo);

    Pelicula findByGenero(String genero);
    
}