package com.kevinlancerio.Ejercicio.Validator;

import com.kevinlancerio.Ejercicio.Entity.DetalleVenta;
import com.kevinlancerio.Ejercicio.Exception.Exception;
import com.kevinlancerio.Ejercicio.Repository.ProductoRepository;
import com.kevinlancerio.Ejercicio.Repository.VentaRepository;
import org.springframework.stereotype.Component;

@Component
public class DetalleVentaValidator {

    private final ProductoRepository productoRepository;
    private final VentaRepository ventaRepository;

    public DetalleVentaValidator(ProductoRepository productoRepository, VentaRepository ventaRepository) {
        this.productoRepository = productoRepository;
        this.ventaRepository = ventaRepository;
    }

    public void DetalleVentaValidar(DetalleVenta detalleVenta) {

        if (!productoRepository.existsById(detalleVenta.getProductos_codigo_producto())) {
            throw new Exception("No se ha encontrado un producto con el id del FK: " + detalleVenta.getProductos_codigo_producto());
        }

        if (!ventaRepository.existsById(detalleVenta.getVentas_codigo_venta())) {
            throw new Exception("No se ha encontrado una venta con el id del FK: " + detalleVenta.getVentas_codigo_venta());
        }

    }

}
