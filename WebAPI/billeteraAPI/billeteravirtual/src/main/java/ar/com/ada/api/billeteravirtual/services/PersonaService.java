package ar.com.ada.api.billeteravirtual.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.repo.PersonaRepository;

/**
 * PersonaService
 */
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
    
}