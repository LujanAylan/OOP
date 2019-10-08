package ar.com.ada.api.billeteravirtual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ada.api.billeteravirtual.entities.Billetera;
import ar.com.ada.api.billeteravirtual.entities.Persona;
import ar.com.ada.api.billeteravirtual.repo.BilleteraRepository;

/**
 * BilleteraService
 */
public class BilleteraService {

    @Autowired
    BilleteraRepository repo;

    public void save(Billetera b){
        repo.save(b);
    }

    public Billetera buscarPorId(int id) {

       Optional<Billetera> b = repo.findById(id);

       if (b.isPresent()) {
           return b.get();
       }
       return null;
    }

    public Billetera buscarPorPersona(Persona p) {
        
        return repo.findByPersona(p);
    }

}