package com.kevinlancerio.Ejercicio.Repository;

import com.kevinlancerio.Ejercicio.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
