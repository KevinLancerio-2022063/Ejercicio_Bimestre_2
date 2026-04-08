package com.kevinlancerio.Ejercicio.Validator;

import com.kevinlancerio.Ejercicio.Entity.Cliente;
import com.kevinlancerio.Ejercicio.Exception.Exception;
import com.kevinlancerio.Ejercicio.Repository.ClienteRepository;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidator {
    private final ClienteRepository clienteRepository;

    public ClienteValidator(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void ClienteValidar(Cliente cliente) {

        if (cliente.getEstado() == null || cliente.getEstado() !=0 && cliente.getEstado() != 1) {
            throw new Exception("El estado debe ser 0 (No disponible) o 1 (Disponible)");
        }

}

}
