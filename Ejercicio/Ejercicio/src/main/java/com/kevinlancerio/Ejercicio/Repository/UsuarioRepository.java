package com.kevinlancerio.Ejercicio.Repository;

import com.kevinlancerio.Ejercicio.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer> {
}
