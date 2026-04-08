package com.kevinlancerio.Ejercicio.Service;

import com.kevinlancerio.Ejercicio.Entity.Venta;
import com.kevinlancerio.Ejercicio.Repository.VentaRepository;
import com.kevinlancerio.Ejercicio.Validator.VentaValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImplements implements VentaService {
    private final VentaRepository ventaRepository;
    private final VentaValidator ventaValidator;

    public VentaServiceImplements (VentaRepository ventaRepository, VentaValidator ventaValidator) {
        this.ventaRepository = ventaRepository;
        this.ventaValidator = ventaValidator;
    }

    @Override
    public List<Venta> getAllVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public Venta getVentasById (Integer id) {
        return ventaRepository.findById(id).orElse(null);
    }

    @Override
    public Venta saveVenta (Venta venta) throws RuntimeException {
        ventaValidator.VentaValidar(venta);
        return ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta (Integer id) {
        ventaRepository.deleteById(id);
    }

    @Override
    public Venta updateVenta (Integer id, Venta venta) {

        Venta ventaExistente = ventaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La venta no se ha encontrado con id: " + id));

        ventaValidator.VentaValidar(venta);
        ventaExistente.setFecha_venta(venta.getFecha_venta());
        ventaExistente.setTotal(venta.getTotal());
        ventaExistente.setEstado(venta.getEstado());
        ventaExistente.setClientes_dpi_cliente(venta.getClientes_dpi_cliente());
        ventaExistente.setUsuarios_codigo_usuario(ventaExistente.getUsuarios_codigo_usuario());

        return ventaRepository.save(ventaExistente);
    }

}
