package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {

    List<DetalleVenta> getAllDetalleVentas();
    DetalleVenta getDetalleVentasById (Integer id);
    DetalleVenta saveDetalleVenta (DetalleVenta detalleVenta) throws RuntimeException;
    DetalleVenta updateDetalleVenta (Integer id, DetalleVenta detalleVenta);
    void deleteDetalleVenta (Integer id);
}
