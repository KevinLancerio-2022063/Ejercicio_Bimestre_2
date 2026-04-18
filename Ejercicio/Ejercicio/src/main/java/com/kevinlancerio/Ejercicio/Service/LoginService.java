package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Login;
import com.kevinlancerio.Ejercicio.Entity.Producto;
import com.kevinlancerio.Ejercicio.Entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {

    Login registrar(String usuario, String password);
    Login login(String usuario, String password);
    List<Login> listar();
    void eliminar (int id);
    Login saveLogin (Login login) throws RuntimeException;
    Login buscarPorUsuario (String usuario);
}
