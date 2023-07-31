package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.Libro;
import com.dbd.Debede.Services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> obtenerTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @GetMapping("/{isbn}")
    public Libro obtenerLibroPorISBN(@PathVariable String isbn) {
        return libroService.obtenerLibroPorISBN(isbn);
    }

    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    @PutMapping("/{isbn}")
    public Libro actualizarLibro(@PathVariable String isbn, @RequestBody Libro libroActualizado) {
        return libroService.actualizarLibro(isbn, libroActualizado);
    }

    @DeleteMapping("/{isbn}")
    public void eliminarLibro(@PathVariable String isbn) {
        libroService.eliminarLibro(isbn);
    }
}
