package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Cliente;
import com.kevinlancerio.Ejercicio.Repository.ClienteRepository;
import com.kevinlancerio.Ejercicio.Validator.ClienteValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImplements implements ClienteService {
    private final ClienteRepository clienteRepository;
    private final ClienteValidator clienteValidator;

    public ClienteServiceImplements(ClienteRepository clienteRepository, ClienteValidator clienteValidator) {
        this.clienteRepository = clienteRepository;
        this.clienteValidator = clienteValidator;
    }

    @Override
    public List<Cliente> getAllClientes() { return clienteRepository.findAll();
    }

    @Override
    public Cliente getClientesById (Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente saveCliente (Cliente cliente) throws RuntimeException {
        clienteValidator.ClienteValidar(cliente);
        return clienteRepository.save(cliente);

    }

    @Override
    public void deleteCliente (Integer id) { clienteRepository.deleteById(id);
    }

    @Override
    public Cliente updateCliente (Integer id, Cliente cliente) {

        Cliente clienteExistente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El cliente no se ha encontrado con id: " + id));

        clienteValidator.ClienteValidar(cliente);
        clienteExistente.setNombre_cliente(cliente.getNombre_cliente());
        clienteExistente.setApellido_cliente(cliente.getApellido_cliente());
        clienteExistente.setDireccion(cliente.getDireccion());
        clienteExistente.setEstado(cliente.getEstado());

        return clienteRepository.save(clienteExistente);
    }
}
