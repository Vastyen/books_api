package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.Valoracion;
import com.dbd.Debede.Repositories.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {
    private final ValoracionRepository valoracionRepository;

    @Autowired
    public ValoracionService(ValoracionRepository valoracionRepository) {
        this.valoracionRepository = valoracionRepository;
    }

    public List<Valoracion> obtenerTodasLasValoraciones() {
        return valoracionRepository.findAll();
    }

    public Valoracion obtenerValoracionPorId(Long id) {
        return valoracionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Valoración no encontrada"));
    }

    public Valoracion crearValoracion(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }

    public Valoracion actualizarValoracion(Long id, Valoracion valoracionActualizada) {
        return valoracionRepository.findById(id)
                .map(valoracion -> {
                    valoracion.setPuntuacion(valoracionActualizada.getPuntuacion());
                    valoracion.setUsuario(valoracionActualizada.getUsuario());
                    valoracion.setIsbnLibro(valoracionActualizada.getIsbnLibro());
                    return valoracionRepository.save(valoracion);
                })
                .orElseThrow(() -> new RuntimeException("Valoración no encontrada"));
    }

    public void eliminarValoracion(Long id) {
        valoracionRepository.deleteById(id);
    }
}
