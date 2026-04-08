package com.kevinlancerio.Ejercicio.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usuario")
    private Integer codigo_usuario;

    @NotBlank(message = "El username no puede estar vacío")
    @Size(max = 45, message = "El username no puede tener más de 45 caracteres")
    @Column(name = "username")
    private String username;

    @NotBlank(message = "El password no puede estar vacío")
    @Size(max = 45, message = "El password no puede tener más de 45 caracteres")
    @Column(name = "password")
    private String password;

    @NotBlank(message = "El email no puede estar vacío")
    @Size(max = 60, message = "El email no puede tener más de 60 caracteres")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "El rol no puede estar vacío")
    @Size(max = 45, message = "El rol no puede tener más de 45 caracteres")
    @Column(name = "rol")
    private String rol;

    @NotNull(message = "El estado no puede estar vacío")
    @Max(value = 1, message = "El estado debe ser 0 (No disponible) o 1 (Disponible)")
    @Column(name = "estado")
    private Integer estado;

    public Integer getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(Integer codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
