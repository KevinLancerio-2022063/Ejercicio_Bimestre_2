package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.Cliente;
import com.kevinlancerio.Ejercicio.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteControllerHTML {

    @Autowired
    private ClienteService service;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", service.getAllClientes());
        return "clientes";
    }

    @PostMapping("/guardar")
    public String guardar(Cliente cliente) {
        service.saveCliente(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        model.addAttribute("cliente", service.getClientesById(id));
        model.addAttribute("clientes", service.getAllClientes());
        return "clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.deleteCliente(id);
        return "redirect:/clientes";
    }
}
