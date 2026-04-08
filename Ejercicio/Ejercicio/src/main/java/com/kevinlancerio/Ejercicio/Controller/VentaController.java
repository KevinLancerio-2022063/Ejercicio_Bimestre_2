package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.Venta;
import com.kevinlancerio.Ejercicio.Service.VentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {
    private final VentaService ventaService;

    public VentaController(VentaService ventaService) {
        this.ventaService = ventaService;
    }

    @GetMapping
    public List<Venta> getAllVentas() {
        return ventaService.getAllVentas();
    }

    @PostMapping
    public ResponseEntity<Object> createVentas(@Valid @RequestBody Venta venta) {
        try {
            Venta createdVenta = ventaService.saveVenta(venta);
            return new ResponseEntity<>(createdVenta, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getVentasById(@PathVariable Integer id) {
        Venta venta = ventaService.getVentasById(id);

        if (venta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Venta no encontrada");
        }
        return ResponseEntity.ok(venta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVenta(@PathVariable Integer id, @Valid @RequestBody Venta venta) {

        Venta actualizado = ventaService.updateVenta(id, venta);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVenta(@PathVariable Integer id) {

        Venta venta = ventaService.getVentasById(id);

        if (venta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Venta no existe");
        }
        ventaService.deleteVenta(id);
        return ResponseEntity.ok("Venta eliminada correctamente");
    }

}


