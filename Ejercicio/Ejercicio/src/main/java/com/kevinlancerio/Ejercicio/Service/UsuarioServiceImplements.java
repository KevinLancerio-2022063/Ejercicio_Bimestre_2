package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Usuario;
import com.kevinlancerio.Ejercicio.Repository.UsuarioRepository;
import com.kevinlancerio.Ejercicio.Validator.UsuarioValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplements implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioValidator usuarioValidator;

    public UsuarioServiceImplements (UsuarioRepository usuarioRepository, UsuarioValidator usuarioValidator) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioValidator = usuarioValidator;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuariosById (Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario saveUsuario (Usuario usuario) throws RuntimeException {
        usuarioValidator.UsuarioValidar(usuario);
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteUsuario (Integer id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario updateUsuario (Integer id, Usuario usuario) {

        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El Usuario no se ha encontrado con id: " + id));

        usuarioValidator.UsuarioValidar(usuario);
        usuarioExistente.setUsername(usuario.getUsername());
        usuarioExistente.setPassword(usuario.getPassword());
        usuarioExistente.setEmail(usuario.getEmail());
        usuarioExistente.setRol(usuario.getRol());
        usuarioExistente.setEstado(usuario.getEstado());

        return usuarioRepository.save(usuarioExistente);
    }
    @Override
    public Usuario buscarPorUsername(String username) {
        return usuarioRepository.findByUsername(username);

    }

}
