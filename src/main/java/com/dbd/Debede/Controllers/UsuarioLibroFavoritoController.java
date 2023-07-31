package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.UsuarioLibroFavorito;
import com.dbd.Debede.Services.UsuarioLibroFavoritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-libros-favoritos")
public class UsuarioLibroFavoritoController {
    private final UsuarioLibroFavoritoService usuarioLibroFavoritoService;

    @Autowired
    public UsuarioLibroFavoritoController(UsuarioLibroFavoritoService usuarioLibroFavoritoService) {
        this.usuarioLibroFavoritoService = usuarioLibroFavoritoService;
    }

    @GetMapping
    public List<UsuarioLibroFavorito> obtenerTodosLosUsuarioLibrosFavoritos() {
        return usuarioLibroFavoritoService.obtenerTodosLosUsuarioLibrosFavoritos();
    }

    @GetMapping("/{id}")
    public UsuarioLibroFavorito obtenerUsuarioLibroFavoritoPorId(@PathVariable Long id) {
        return usuarioLibroFavoritoService.obtenerUsuarioLibroFavoritoPorId(id);
    }

    @PostMapping
    public UsuarioLibroFavorito crearUsuarioLibroFavorito(@RequestBody UsuarioLibroFavorito usuarioLibroFavorito) {
        return usuarioLibroFavoritoService.crearUsuarioLibroFavorito(usuarioLibroFavorito);
    }

    @PutMapping("/{id}")
    public UsuarioLibroFavorito actualizarUsuarioLibroFavorito(@PathVariable Long id, @RequestBody UsuarioLibroFavorito usuarioLibroFavoritoActualizado) {
        return usuarioLibroFavoritoService.actualizarUsuarioLibroFavorito(id, usuarioLibroFavoritoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuarioLibroFavorito(@PathVariable Long id) {
        usuarioLibroFavoritoService.eliminarUsuarioLibroFavorito(id);
    }
}
