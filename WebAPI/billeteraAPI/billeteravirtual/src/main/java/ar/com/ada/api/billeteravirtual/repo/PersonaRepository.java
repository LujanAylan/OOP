package ar.com.ada.api.billeteravirtual.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.billeteravirtual.entities.*;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    Persona findByNombre(String nombrePersona);

    Persona findByDni(String dni);

    //Este caso aplica al named query creado en el objeto persona
    List<Persona> findAllByNombreContiene(String nombre);

    //Igual al caso anterior pero con 2 parametros.
    List<Persona> findAllByNombreAndDNI(String nombre, String dni);

    @Query("select p from Persona p order by nombre")
    List<Persona> findAllOrderByNombre();
}