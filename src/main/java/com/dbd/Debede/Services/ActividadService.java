package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.Actividad;
import com.dbd.Debede.Repositories.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActividadService {
    private final ActividadRepository actividadRepository;

    @Autowired
    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public List<Actividad> obtenerTodasLasActividades() {
        return actividadRepository.findAll();
    }

    public Actividad obtenerActividadPorId(Long id) {
        return actividadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    public Actividad crearActividad(Actividad actividad) {
        return actividadRepository.save(actividad);
    }

    public Actividad actualizarActividad(Long id, Actividad actividadActualizada) {
        return actividadRepository.findById(id)
                .map(actividad -> {
                    actividad.setCantidadLibrosPublicados(actividadActualizada.getCantidadLibrosPublicados());
                    actividad.setPromedioLibrosPublicados(actividadActualizada.getPromedioLibrosPublicados());
                    actividad.setDesviacionLibrosPublicados(actividadActualizada.getDesviacionLibrosPublicados());
                    actividad.setUsuario(actividadActualizada.getUsuario());
                    return actividadRepository.save(actividad);
                })
                .orElseThrow(() -> new RuntimeException("Actividad no encontrada"));
    }

    public void eliminarActividad(Long id) {
        actividadRepository.deleteById(id);
    }
}
