package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.UsuarioLibro;
import com.dbd.Debede.Services.UsuarioLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario-libros")
public class UsuarioLibroController {
    private final UsuarioLibroService usuarioLibroService;

    @Autowired
    public UsuarioLibroController(UsuarioLibroService usuarioLibroService) {
        this.usuarioLibroService = usuarioLibroService;
    }

    @GetMapping
    public List<UsuarioLibro> obtenerTodosLosUsuarioLibros() {
        return usuarioLibroService.obtenerTodosLosUsuarioLibros();
    }

    @GetMapping("/{id}")
    public UsuarioLibro obtenerUsuarioLibroPorId(@PathVariable Long id) {
        return usuarioLibroService.obtenerUsuarioLibroPorId(id);
    }

    @PostMapping
    public UsuarioLibro crearUsuarioLibro(@RequestBody UsuarioLibro usuarioLibro) {
        return usuarioLibroService.crearUsuarioLibro(usuarioLibro);
    }

    @PutMapping("/{id}")
    public UsuarioLibro actualizarUsuarioLibro(@PathVariable Long id, @RequestBody UsuarioLibro usuarioLibroActualizado) {
        return usuarioLibroService.actualizarUsuarioLibro(id, usuarioLibroActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuarioLibro(@PathVariable Long id) {
        usuarioLibroService.eliminarUsuarioLibro(id);
    }
}
