package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClienteService {

    List<Cliente> getAllClientes();
    Cliente getClientesById (Integer id);
    Cliente saveCliente (Cliente cliente) throws RuntimeException;
    Cliente updateCliente (Integer id, Cliente cliente);
    void deleteCliente (Integer id);
}
