package com.kevinlancerio.Ejercicio.Validator;

import com.kevinlancerio.Ejercicio.Entity.Venta;
import com.kevinlancerio.Ejercicio.Exception.Exception;
import com.kevinlancerio.Ejercicio.Repository.ClienteRepository;
import com.kevinlancerio.Ejercicio.Repository.UsuarioRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class VentaValidator {

    private final ClienteRepository clienteRepository;
    private final UsuarioRepository usuarioRepository;

    public VentaValidator(ClienteRepository clienteRepository, UsuarioRepository usuarioRepository) {
        this.clienteRepository = clienteRepository;
        this.usuarioRepository = usuarioRepository;

    }

    public void VentaValidar(Venta venta) {

        if (!clienteRepository.existsById(venta.getClientes_dpi_cliente())) {
            throw new Exception("No se ha encontrado un cliente con el id del FK: " + venta.getClientes_dpi_cliente());
        }

        if (!usuarioRepository.existsById(venta.getUsuarios_codigo_usuario())) {
            throw new Exception("No se ha encontrado un usuario con el id del FK: " + venta.getUsuarios_codigo_usuario());
        }

        if (venta.getFecha_venta() != null && venta.getFecha_venta().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha no puede ser anterior a la fecha actual");
        }

    }

}