package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Login;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {

    Login registrar(String usuario, String password);
    Login login(String usuario, String password);
    List<Login> listar();
    void eliminar (int id);
}
