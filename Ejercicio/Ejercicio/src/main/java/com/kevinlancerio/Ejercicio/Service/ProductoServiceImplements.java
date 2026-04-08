package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Producto;
import com.kevinlancerio.Ejercicio.Repository.ProductoRepository;
import com.kevinlancerio.Ejercicio.Validator.ProductoValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplements implements ProductoService {
    private final ProductoRepository productoRepository;
    private final ProductoValidator productoValidator;

    public ProductoServiceImplements (ProductoRepository productoRepository, ProductoValidator productoValidator) {
        this.productoRepository = productoRepository;
        this.productoValidator = productoValidator;
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto getProductosById (Integer id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto saveProducto (Producto producto) throws RuntimeException {
        productoValidator.ProductoValidar(producto);
        return productoRepository.save(producto);
    }

    @Override
    public void deleteProducto (Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto updateProducto (Integer id, Producto producto) {

        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El producto no se ha encontrado con: " + id));

        productoValidator.ProductoValidar(producto);
        productoExistente.setNombre_producto(producto.getNombre_producto());
        productoExistente.setPrecio(producto.getPrecio());
        productoExistente.setStock(producto.getStock());
        productoExistente.setEstado(producto.getEstado());

        return productoRepository.save(productoExistente);
    }

}

