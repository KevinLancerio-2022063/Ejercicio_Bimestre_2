package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    List<Producto> getAllProductos();
    Producto getProductosById (Integer id);
    Producto saveProducto (Producto producto) throws RuntimeException;
    Producto updateProducto (Integer id, Producto producto);
    void deleteProducto (Integer id);
}
