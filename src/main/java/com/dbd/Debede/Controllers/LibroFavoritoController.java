package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.LibroFavorito;
import com.dbd.Debede.Services.LibroFavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros-favoritos")
public class LibroFavoritoController {
    private final LibroFavoritoService libroFavoritoService;

    @Autowired
    public LibroFavoritoController(LibroFavoritoService libroFavoritoService) {
        this.libroFavoritoService = libroFavoritoService;
    }

    @GetMapping
    public List<LibroFavorito> obtenerTodosLosLibrosFavoritos() {
        return libroFavoritoService.obtenerTodosLosLibrosFavoritos();
    }

    @GetMapping("/{id}")
    public LibroFavorito obtenerLibroFavoritoPorId(@PathVariable Long id) {
        return libroFavoritoService.obtenerLibroFavoritoPorId(id);
    }

    @PostMapping
    public LibroFavorito crearLibroFavorito(@RequestBody LibroFavorito libroFavorito) {
        return libroFavoritoService.crearLibroFavorito(libroFavorito);
    }

    @PutMapping("/{id}")
    public LibroFavorito actualizarLibroFavorito(@PathVariable Long id, @RequestBody LibroFavorito libroFavoritoActualizado) {
        return libroFavoritoService.actualizarLibroFavorito(id, libroFavoritoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibroFavorito(@PathVariable Long id) {
        libroFavoritoService.eliminarLibroFavorito(id);
    }
}
