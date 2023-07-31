package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.Valoracion;
import com.dbd.Debede.Services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {
    private final ValoracionService valoracionService;

    @Autowired
    public ValoracionController(ValoracionService valoracionService) {
        this.valoracionService = valoracionService;
    }

    @GetMapping
    public List<Valoracion> obtenerTodasLasValoraciones() {
        return valoracionService.obtenerTodasLasValoraciones();
    }

    @GetMapping("/{id}")
    public Valoracion obtenerValoracionPorId(@PathVariable Long id) {
        return valoracionService.obtenerValoracionPorId(id);
    }

    @PostMapping
    public Valoracion crearValoracion(@RequestBody Valoracion valoracion) {
        return valoracionService.crearValoracion(valoracion);
    }

    @PutMapping("/{id}")
    public Valoracion actualizarValoracion(@PathVariable Long id, @RequestBody Valoracion valoracionActualizada) {
        return valoracionService.actualizarValoracion(id, valoracionActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarValoracion(@PathVariable Long id) {
        valoracionService.eliminarValoracion(id);
    }
}
