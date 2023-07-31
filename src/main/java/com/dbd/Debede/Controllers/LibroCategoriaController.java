package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.LibroCategoria;
import com.dbd.Debede.Services.LibroCategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros-categorias")
public class LibroCategoriaController {
    private final LibroCategoriaService libroCategoriaService;

    @Autowired
    public LibroCategoriaController(LibroCategoriaService libroCategoriaService) {
        this.libroCategoriaService = libroCategoriaService;
    }

    @GetMapping
    public List<LibroCategoria> obtenerTodosLosLibrosCategorias() {
        return libroCategoriaService.obtenerTodosLosLibrosCategorias();
    }

    @GetMapping("/{id}")
    public LibroCategoria obtenerLibroCategoriaPorId(@PathVariable Long id) {
        return libroCategoriaService.obtenerLibroCategoriaPorId(id);
    }

    @PostMapping
    public LibroCategoria crearLibroCategoria(@RequestBody LibroCategoria libroCategoria) {
        return libroCategoriaService.crearLibroCategoria(libroCategoria);
    }

    @PutMapping("/{id}")
    public LibroCategoria actualizarLibroCategoria(@PathVariable Long id, @RequestBody LibroCategoria libroCategoriaActualizada) {
        return libroCategoriaService.actualizarLibroCategoria(id, libroCategoriaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibroCategoria(@PathVariable Long id) {
        libroCategoriaService.eliminarLibroCategoria(id);
    }
}
