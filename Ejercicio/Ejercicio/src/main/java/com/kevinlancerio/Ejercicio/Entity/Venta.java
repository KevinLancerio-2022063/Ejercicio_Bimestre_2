package com.kevinlancerio.Ejercicio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_venta")
    private Integer codigo_venta;

    @NotNull(message = "La fecha de venta no puede estar vacío")
    @Column(name = "fecha_venta")
    private LocalDate fecha_venta;

    @NotNull(message = "El total no puede estar vacío")
    @Positive(message = "El total no puede ser menor que 1")
    @Column(name = "total")
    private Double total;

    @NotNull(message = "El estado no puede estar vacío")
    @Positive(message = "El estado no puede ser menor que 1")
    @Column(name = "estado")
    private Integer estado;

    @NotNull(message = "El FK_cliente_dpi_cliente no puede estar vacío")
    @Positive(message = "El FK no puede ser menor que 1 ")
    @Column(name = "clientes_dpi_cliente")
    private Integer clientes_dpi_cliente;

    @NotNull(message = "El FK_usuarios_codigo_usuario no puede estar vacío")
    @Max(value = 1, message = "El FK no puede ser menor que 1 ")
    @Column(name = "usuarios_codigo_usuario")
    private Integer usuarios_codigo_usuario;

    public Integer getCodigo_venta() {
        return codigo_venta;
    }

    public void setCodigo_venta(Integer codigo_venta) {
        this.codigo_venta = codigo_venta;
    }

    public LocalDate getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(LocalDate fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public Integer getClientes_dpi_cliente() {
        return clientes_dpi_cliente;
    }

    public void setClientes_dpi_cliente(Integer clientes_dpi_cliente) {
        this.clientes_dpi_cliente = clientes_dpi_cliente;
    }

    public Integer getUsuarios_codigo_usuario() {
        return usuarios_codigo_usuario;
    }

    public void setUsuarios_codigo_usuario(Integer usuarios_codigo_usuario) {
        this.usuarios_codigo_usuario = usuarios_codigo_usuario;
    }
}
