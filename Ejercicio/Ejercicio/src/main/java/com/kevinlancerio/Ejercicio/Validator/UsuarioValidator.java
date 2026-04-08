package com.kevinlancerio.Ejercicio.Validator;

import com.kevinlancerio.Ejercicio.Entity.Usuario;
import com.kevinlancerio.Ejercicio.Exception.Exception;
import com.kevinlancerio.Ejercicio.Repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioValidator {

    private final UsuarioRepository usuarioRepository;

    public UsuarioValidator(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void UsuarioValidar(Usuario usuario) {

        List<Usuario> usuarios = usuarioRepository.findAll();
        String correoUsu = usuario.getEmail();
        Integer estado = usuario.getEstado();

        correoUsu = correoUsu.trim().toLowerCase();

        if (!(correoUsu.endsWith("@gmail.com") || correoUsu.endsWith("@outlook.com") || correoUsu.endsWith("@yahoo.com"))) {
            throw new Exception("El correo del usuario debe terminar con @gmail.com, @outlook.com o @yahoo.com");
        }

        for (Usuario correoUsua : usuarios) {
            if (correoUsu.equals(correoUsua.getEmail())) {
                throw new Exception("El correo de este usuario ya existe");
            }

        }

        if (usuario.getEstado() == null || usuario.getEstado() !=0 && usuario.getEstado() != 1)  {
            throw new Exception("El estado debe ser 0 (No disponible) o 1 (Disponible)");
        }

    }

}
