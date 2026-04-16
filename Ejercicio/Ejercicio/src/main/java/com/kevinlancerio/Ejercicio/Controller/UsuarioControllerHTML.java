package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.Usuario;
import com.kevinlancerio.Ejercicio.Service.UsuarioService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/usuarios")
public class UsuarioControllerHTML {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("usuarios", service.getAllUsuarios());
        return "usuarios";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        service.saveUsuario(usuario); // INSERT o UPDATE
        return "redirect:/usuarios";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("usuario", service.getUsuariosById(id));
        model.addAttribute("usuarios", service.getAllUsuarios());
        return "usuarios";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.deleteUsuario(id);
        return "redirect:/usuarios";
    }

}