package com.kevinlancerio.Ejercicio.Repository;

import com.kevinlancerio.Ejercicio.Entity.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleVentaRepository extends JpaRepository <DetalleVenta, Integer> {
}
