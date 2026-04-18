package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Login;
import com.kevinlancerio.Ejercicio.Entity.Producto;
import com.kevinlancerio.Ejercicio.Entity.Usuario;
import com.kevinlancerio.Ejercicio.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImplements implements LoginService {

    @Autowired
    private LoginRepository repo;

    @Override
    public Login registrar(String usuario, String password) {

        if (repo.findByUsuario(usuario) != null) {
            return null;
        }

        Login l = new Login();
        l.setUsuario(usuario);
        l.setPassword(password);

        return repo.save(l);
    }

    @Override
    public Login login(String usuario, String password) {

        Login l = repo.findByUsuario(usuario);

        if (l != null && l.getPassword().equals(password)) {
            return l;
        }

        return null;
    }

    @Override
    public List<Login> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(int id) {
        repo.deleteById(id);
    }

    @Override
    public Login saveLogin(Login login) throws RuntimeException {
       return repo.save(login);
    }

    @Override
    public Login buscarPorUsuario (String Usuario) {
        return repo.findByUsuario(Usuario);
    }
}

