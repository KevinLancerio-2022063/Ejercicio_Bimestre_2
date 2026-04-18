package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.Login;

import com.kevinlancerio.Ejercicio.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;


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
                          @RequestParam String rol,
                          HttpSession session,
                          Model model) {

        Login l = service.login(usuario, password);

        if (l != null) {

            if (l.getRol().equals(rol)) {

                session.setAttribute("usuario", l.getUsuario());
                session.setAttribute("rol", l.getRol());

                if ("ADMIN".equals(rol)) {
                    return "redirect:/menu";
                } else if ("USER".equals(rol)) {
                    return "redirect:/menu";

                }

            } else {
                model.addAttribute("Error", "Acceso denegado, solo puede ingresar un ADMIN");
                return "loginInicio";
            }


        } else {
            model.addAttribute("error", "Credenciales incorrectas");
        }
        return "loginInicio";

    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String usuario,
                          @RequestParam String password,
                          Model model) {

        Login log = new Login();
        log.setUsuario(usuario);
        log.setPassword(password);
        log.setRol("USER");

        service.saveLogin(log);

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

    @PostMapping("/subirImagen")
    public String subirImagen(@RequestParam("file") MultipartFile file,
                              HttpSession session) {

        try {
            String usuario = (String) session.getAttribute("usuario");
            Login l = service.buscarPorUsuario(usuario);

            if (!file.isEmpty()) {
                l.setImagen(file.getBytes());
                service.saveLogin(l);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/menu";
    }

    @GetMapping("/loginInicio/imagen")
    @ResponseBody
    public ResponseEntity<byte[]> mostrarImagen(HttpSession session) {

        try {
            String usuario = (String) session.getAttribute("usuario");
            Login user = service.buscarPorUsuario(usuario);

            if (user.getImagen() != null) {
                return ResponseEntity
                        .ok()
                        .header("Content-Type", "image/jpeg")
                        .body(user.getImagen());
            }

            InputStream is = new ClassPathResource("static/images/UsuarioPerfil.webp").getInputStream();
            byte[] img = is.readAllBytes();

            return ResponseEntity
                    .ok()
                    .header("Content-Type", "image/webp")
                    .body(img);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    // Cerrar sesión
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        // El session invalidate se utiliza para invalidar una sesion, es decir, elimina toda la informacion almacenada en la sesion
        session.invalidate();
        return "redirect:/loginInicio";
    }

}
