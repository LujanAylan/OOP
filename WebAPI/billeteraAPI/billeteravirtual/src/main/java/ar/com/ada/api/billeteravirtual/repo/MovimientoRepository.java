package ar.com.ada.api.billeteravirtual.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.billeteravirtual.entities.Movimiento;

/**
 * MovimientoRepository
 */
@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    @Query("select m from Movimiento m order by fecha")
    List<Movimiento> findAllOrderByFecha();
    
}