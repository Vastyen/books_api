package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.Transaccion;
import com.dbd.Debede.Services.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    private final TransaccionService transaccionService;

    @Autowired
    public TransaccionController(TransaccionService transaccionService) {
        this.transaccionService = transaccionService;
    }

    @GetMapping
    public List<Transaccion> obtenerTodasLasTransacciones() {
        return transaccionService.obtenerTodasLasTransacciones();
    }

    @GetMapping("/{id}")
    public Transaccion obtenerTransaccionPorId(@PathVariable Long id) {
        return transaccionService.obtenerTransaccionPorId(id);
    }

    @PostMapping
    public Transaccion crearTransaccion(@RequestBody Transaccion transaccion) {
        return transaccionService.crearTransaccion(transaccion);
    }

    @PutMapping("/{id}")
    public Transaccion actualizarTransaccion(@PathVariable Long id, @RequestBody Transaccion transaccionActualizada) {
        return transaccionService.actualizarTransaccion(id, transaccionActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarTransaccion(@PathVariable Long id) {
        transaccionService.eliminarTransaccion(id);
    }
}
