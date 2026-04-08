package com.kevinlancerio.Ejercicio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "detalleventas")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_detalle_venta")
    private Integer codigo_detalle_venta;

    @NotNull(message = "La cantidad no puede estar vacía")
    @Positive(message = "La cantidad no puede ser menor que 1")
    @Column(name = "cantidad")
    private Integer cantidad;

    @NotNull(message = "El precio unitario no puede estar vacío")
    @Positive(message = "El precio unitario no puede ser menor que 1")
    @Column(name = "precio_unitario")
    private Double precio_unitario;

    @NotNull(message = "El subtotal no puede estar vacío")
    @Positive(message = "El subtotal no puede ser menor que 1")
    @Column(name = "subtotal")
    private Double subtotal;

    @NotNull(message = "El FK_productos_codigo_producto no puede estar vacío")
    @Positive(message = "El FK_producto_codigo_producto no puede ser menor que 1")
    @Column(name = "productos_codigo_producto")
    private Integer productos_codigo_producto;

    @NotNull(message = "El FK_venta_codigo_venta no puede estar vacío")
    @Positive(message = "El FK_venta_codigo_venta no puede ser menor que 1")
    @Column(name = "ventas_codigo_venta")
    private Integer ventas_codigo_venta;

    public Integer getCodigo_detalle_venta() {
        return codigo_detalle_venta;
    }

    public void setCodigo_detalle_venta(Integer codigo_detalle_venta) {
        this.codigo_detalle_venta = codigo_detalle_venta;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getProductos_codigo_producto() {
        return productos_codigo_producto;
    }

    public void setProductos_codigo_producto(Integer productos_codigo_producto) {
        this.productos_codigo_producto = productos_codigo_producto;
    }

    public Integer getVentas_codigo_venta() {
        return ventas_codigo_venta;
    }

    public void setVentas_codigo_venta(Integer ventas_codigo_venta) {
        this.ventas_codigo_venta = ventas_codigo_venta;
    }
}