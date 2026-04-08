package com.kevinlancerio.Ejercicio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_producto")
    private Integer codigo_producto;

    @NotBlank(message = "El nombre del producto no puede estar vacío")
    @Size(max = 60, message = "El nombre del producto no puede tener más de 60 caracteres")
    @Column(name = "nombre_producto")
    private String nombre_producto;

    @NotNull(message = "El precio no puede estar vacío")
    @Positive(message = "El precio no puede ser menor que 1")
    @Column(name = "precio")
    private Double precio;

    @NotNull(message = "El stock no puede estar vacío")
    @Positive(message = "El stock no puede ser menor que 1")
    @Column(name = "stock")
    private Integer stock;

    @NotNull(message = "El estado no puede estar vacío")
    @Max(value = 1, message = "El estado debe ser 0 (No disponible) o 1 (Disponible")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(Integer codigo_producto) {
        this.codigo_producto = codigo_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
