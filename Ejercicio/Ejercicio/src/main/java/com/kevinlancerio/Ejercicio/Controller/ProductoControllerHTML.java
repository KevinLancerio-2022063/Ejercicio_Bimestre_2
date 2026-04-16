package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.Producto;
import com.kevinlancerio.Ejercicio.Service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoControllerHTML {

    @Autowired
    private ProductoService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("producto", new Producto());
        model.addAttribute("productos", service.getAllProductos());
        return "productos";
    }

    @PostMapping("/guardar")
    public String guardar(Producto producto, HttpSession session) {
        service.saveProducto(producto);
        return "redirect:/productos";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {

        model.addAttribute("producto", service.getProductosById(id));
        model.addAttribute("productos", service.getAllProductos());
        return "productos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.deleteProducto(id);
        return "redirect:/productos";
    }

}
