package com.kevinlancerio.Ejercicio.Validator;

import com.kevinlancerio.Ejercicio.Entity.Producto;
import com.kevinlancerio.Ejercicio.Exception.Exception;
import com.kevinlancerio.Ejercicio.Repository.ProductoRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductoValidator {
    private final ProductoRepository productoRepository;

    public ProductoValidator(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void ProductoValidar(Producto producto) {

        if (producto.getEstado() == null || producto.getEstado() != 0 && producto.getEstado() != 1) {
            throw new Exception("El estado debe ser 0 (No disponible) o 1 (Disponible)");

        }
    }

}
