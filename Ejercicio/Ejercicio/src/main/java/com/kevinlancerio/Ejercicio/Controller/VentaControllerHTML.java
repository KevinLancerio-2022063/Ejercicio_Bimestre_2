package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.Venta;
import com.kevinlancerio.Ejercicio.Service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaControllerHTML {

    @Autowired
    private VentaService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("venta", new Venta());
        model.addAttribute("ventas", service.getAllVentas());
        return "ventas";
    }

    @PostMapping("/guardar")
    public String guardar(Venta venta) {
        service.saveVenta(venta);
        return "redirect:/ventas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("venta", service.getVentasById(id));
        model.addAttribute("ventas", service.getAllVentas());
        return "ventas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.deleteVenta(id);
        return "redirect:/ventas";
    }
}
