package ar.com.ada.api.billeteravirtual.repo;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import ar.com.ada.api.billeteravirtual.entities.Movimiento;

/**
 * MovimientoRepository
 */
@Repository
public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
    @Query("select m from Movimiento m order by fecha")
    List<Movimiento> findAllOrderByFecha();

    @Query("SELECT m FROM Movimiento m WHERE m.cuenta.billetera.billeteraId = :billeteraId AND m.cuenta.moneda= :moneda ORDER BY fechaMovimiento desc")
    List<Movimiento> FindOrderByFecha(@Param("billeteraId") int billeteraId,@Param("moneda") String moneda);
}