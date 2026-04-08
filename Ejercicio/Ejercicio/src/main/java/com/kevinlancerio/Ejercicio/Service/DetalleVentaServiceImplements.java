package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.DetalleVenta;
import com.kevinlancerio.Ejercicio.Repository.DetalleVentaRepository;
import com.kevinlancerio.Ejercicio.Validator.DetalleVentaValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;
    private final DetalleVentaValidator detalleVentaValidator;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository, DetalleVentaValidator detalleVentaValidator) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.detalleVentaValidator = detalleVentaValidator;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVentas() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentasById (Integer id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleVenta saveDetalleVenta (DetalleVenta detalleVenta) throws RuntimeException {
        detalleVentaValidator.DetalleVentaValidar(detalleVenta);
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public void deleteDetalleVenta (Integer id) {
        detalleVentaRepository.deleteById(id);
    }

    @Override
    public DetalleVenta updateDetalleVenta (Integer id, DetalleVenta detalleVenta) {

        DetalleVenta detalleVentaExistente = detalleVentaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("El Detalle Venta no se ha encontrado con" + id));

        detalleVentaValidator.DetalleVentaValidar(detalleVenta);
        detalleVentaExistente.setCantidad(detalleVenta.getCantidad());
        detalleVentaExistente.setPrecio_unitario(detalleVenta.getPrecio_unitario());
        detalleVentaExistente.setSubtotal(detalleVenta.getSubtotal());
        detalleVentaExistente.setProductos_codigo_producto(detalleVenta.getProductos_codigo_producto());
        detalleVentaExistente.setVentas_codigo_venta(detalleVenta.getVentas_codigo_venta());

        return detalleVentaRepository.save(detalleVentaExistente);
    }
}
