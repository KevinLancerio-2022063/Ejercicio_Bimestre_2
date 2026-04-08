package com.kevinlancerio.Ejercicio.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Inicio
    @GetMapping("/")
    public String inicio() {
        return "redirect:/usuario";
    }

    // Mostrar login
    @GetMapping("/usuario")
    public String mostrarLogin() {
        return "usuario";
    }

    // Procesar login
    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        String userCorrecto = "admin";
        String passCorrecto = "1234";

        if (usuario.equals(userCorrecto) && password.equals(passCorrecto)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/menu";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "usuario";
        }
    }

    // Menú principal
    @GetMapping("/menu")
    public String menu(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "menu";
    }

    // Página usuarios
    @GetMapping("/usuarios")
    public String usuarios(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "usuarios";
    }

    // Página productos
    @GetMapping("/productos")
    public String productos(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "productos";
    }

    // Logout
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/usuario";
    }
}

