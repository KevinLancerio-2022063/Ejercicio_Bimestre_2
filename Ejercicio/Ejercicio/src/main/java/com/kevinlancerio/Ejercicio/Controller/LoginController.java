package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.Login;

import com.kevinlancerio.Ejercicio.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/loginInicio")
    public String login() {
        return "loginInicio";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String usuario,
                          @RequestParam String password,
                          HttpSession session,
                          Model model) {

        Login l = service.login(usuario, password);

        if (l != null) {

            session.setAttribute("usuario", l.getUsuario());
            session.setAttribute("rol", l.getRol());

            return "redirect:/menu";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
            return "loginInicio";
        }
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model) {

        Login l = service.registrar(usuario, password);

        if (l == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "registro";
        }

        return "redirect:/loginInicio";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    // Cerrar sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // El session invalidate se utiliza para invalidar una sesion, es decir, elimina toda la informacion almacenada en la sesion
        session.invalidate();
        return "redirect:/loginInicio";
    }

}
