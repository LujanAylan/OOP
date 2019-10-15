package ar.com.ada.api.billeteravirtual.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.repo.PersonaRepository;

/**
 * PersonaService
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository repo;

    public List<Persona> getPersonas() {
        return repo.findAll();
    }

    public Persona buscarPorId(int id) {

        Optional<Persona> p = repo.findById(id);
        
        if (p.isPresent())
            return p.get();
        return null;
    }

    public List<Persona> buscarPersonasOrdenadoPorNombre() {

        return repo.findAllOrderByNombre();
    }

    public Persona buscarPorNombre(String nombre) {

        return repo.findByNombre(nombre);
    }
 
    public List<Persona> buscarTodosPorNombre(String nombre) {

        return repo.findAllByNombreContiene(nombre);
    }
    
    public Persona buscarPorDni(String dni) {

        return repo.findByDni(dni);
    }

    public void save(Persona persona){
        repo.save(persona);
    }

}