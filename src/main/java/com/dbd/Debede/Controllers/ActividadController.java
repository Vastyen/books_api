package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.Actividad;
import com.dbd.Debede.Services.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actividades")
public class ActividadController {
    private final ActividadService actividadService;

    @Autowired
    public ActividadController(ActividadService actividadService) {
        this.actividadService = actividadService;
    }

    @GetMapping
    public List<Actividad> obtenerTodasLasActividades() {
        return actividadService.obtenerTodasLasActividades();
    }

    @GetMapping("/{id}")
    public Actividad obtenerActividadPorId(@PathVariable Long id) {
        return actividadService.obtenerActividadPorId(id);
    }

    @PostMapping
    public Actividad crearActividad(@RequestBody Actividad actividad) {
        return actividadService.crearActividad(actividad);
    }

    @PutMapping("/{id}")
    public Actividad actualizarActividad(@PathVariable Long id, @RequestBody Actividad actividadActualizada) {
        return actividadService.actualizarActividad(id, actividadActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarActividad(@PathVariable Long id) {
        actividadService.eliminarActividad(id);
    }
}
