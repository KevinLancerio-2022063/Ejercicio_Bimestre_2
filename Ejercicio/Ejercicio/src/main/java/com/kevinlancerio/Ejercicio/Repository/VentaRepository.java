package com.kevinlancerio.Ejercicio.Repository;

import com.kevinlancerio.Ejercicio.Entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository extends JpaRepository <Venta, Integer> {
}
