package com.kevinlancerio.Ejercicio.Controller;

import com.kevinlancerio.Ejercicio.Entity.DetalleVenta;
import com.kevinlancerio.Ejercicio.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleVentas")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> getAllDetalleVentas() {
        return detalleVentaService.getAllDetalleVentas();
    }

    @PostMapping
    public ResponseEntity<Object> createDetalleVenta(@Valid @RequestBody DetalleVenta detalleVenta) {
        try {
            DetalleVenta createdDetalleVenta = detalleVentaService.saveDetalleVenta(detalleVenta);
            return new ResponseEntity<>(createdDetalleVenta, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>getDetalleVentasById(@PathVariable Integer id) {
        DetalleVenta detalleVenta = detalleVentaService.getDetalleVentasById(id);

        if (detalleVenta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalle Venta no encontrado");
        }
        return ResponseEntity.ok(detalleVenta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetalleVenta(@PathVariable Integer id, @Valid @RequestBody DetalleVenta detalleVenta) {

        DetalleVenta actualizado = detalleVentaService.updateDetalleVenta(id, detalleVenta);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetalleVenta(@PathVariable Integer id) {

        DetalleVenta detalleVenta = detalleVentaService.getDetalleVentasById(id);

        if (detalleVenta == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Detalle Venta no existe");
        }

        detalleVentaService.deleteDetalleVenta(id);
        return ResponseEntity.ok("Detalle Venta eliminado correctamente");
    }
}

