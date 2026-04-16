package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.DetalleVenta;
import com.kevinlancerio.Ejercicio.Service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalleVentas")
public class DetalleVentaControllerHTML {

    @Autowired
    private DetalleVentaService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("detalle", new DetalleVenta());
        model.addAttribute("detalles", service.getAllDetalleVentas());
        return "detalleVentas";
    }

    @PostMapping("/guardar")
    public String guardar(DetalleVenta detalle) {
        service.saveDetalleVenta(detalle);
        return "redirect:/detalleVentas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("detalle", service.getDetalleVentasById(id));
        model.addAttribute("detalles", service.getAllDetalleVentas());
        return "detalleVentas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.deleteDetalleVenta(id);
        return "redirect:/detalleVentas";
    }
}
