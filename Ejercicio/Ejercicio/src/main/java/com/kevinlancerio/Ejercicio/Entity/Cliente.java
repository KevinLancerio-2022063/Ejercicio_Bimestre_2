package com.kevinlancerio.Ejercicio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dpi_cliente")
    private Integer dpi_cliente;

    @NotBlank(message = "El nombre del cliente no puede estar vacío")
    @Size(max = 50, message = "El nombre del cliente no puede tener más de 50 caracteres")
    @Column(name = "nombre_cliente")
    private String nombre_cliente;

    @NotBlank(message = "El apellido del cliente no puede estar vacío")
    @Size(max = 50, message = "El apellido del cliente no puede tener más de 50 caracteres")
    @Column(name = "apellido_cliente")
    private String apellido_cliente;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 100, message = "La dirección no puede tener más de 100 caracteres")
    @Column(name = "direccion")
    private String direccion;

    @NotNull(message = "El estado no puede estar vacío")
    @Max(value = 1, message = "El estado debe ser un 0 (No disponible) o 1 (Disponible)")
    @Column(name = "estado")
    private Integer estado;

    public Integer getDpi_cliente() {
        return dpi_cliente;
    }

    public void setDpi_cliente(Integer dpi_cliente) {
        this.dpi_cliente = dpi_cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getApellido_cliente() {
        return apellido_cliente;
    }

    public void setApellido_cliente(String apellido_cliente) {
        this.apellido_cliente = apellido_cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
