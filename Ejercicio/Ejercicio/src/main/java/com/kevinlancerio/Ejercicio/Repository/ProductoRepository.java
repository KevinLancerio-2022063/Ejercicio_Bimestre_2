package com.kevinlancerio.Ejercicio.Repository;

import com.kevinlancerio.Ejercicio.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository <Producto, Integer> {

}