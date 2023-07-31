package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.Transaccion;
import com.dbd.Debede.Repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransaccionService {
    private final TransaccionRepository transaccionRepository;

    @Autowired
    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public List<Transaccion> obtenerTodasLasTransacciones() {
        return transaccionRepository.findAll();
    }

    public Transaccion obtenerTransaccionPorId(Long id) {
        return transaccionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transacción no encontrada"));
    }

    public Transaccion crearTransaccion(Transaccion transaccion) {
        return transaccionRepository.save(transaccion);
    }

    public Transaccion actualizarTransaccion(Long id, Transaccion transaccionActualizada) {
        return transaccionRepository.findById(id)
                .map(transaccion -> {
                    transaccion.setPrecioTotal(transaccionActualizada.getPrecioTotal());
                    transaccion.setMedioDePago(transaccionActualizada.getMedioDePago());
                    transaccion.setCarroDeCompras(transaccionActualizada.getCarroDeCompras());
                    transaccion.setEstadoTransaccion(transaccionActualizada.getEstadoTransaccion());
                    return transaccionRepository.save(transaccion);
                })
                .orElseThrow(() -> new RuntimeException("Transacción no encontrada"));
    }

    public void eliminarTransaccion(Long id) {
        transaccionRepository.deleteById(id);
    }
}
