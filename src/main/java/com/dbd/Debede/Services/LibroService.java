package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.Libro;
import com.dbd.Debede.Repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    public Libro obtenerLibroPorISBN(String isbn) {
        return libroRepository.findById(isbn)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    public Libro crearLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public Libro actualizarLibro(String isbn, Libro libroActualizado) {
        return libroRepository.findById(isbn)
                .map(libro -> {
                    libro.setNombre(libroActualizado.getNombre());
                    libro.setAutor(libroActualizado.getAutor());
                    libro.setVisualizaciones(libroActualizado.getVisualizaciones());
                    libro.setPrecio(libroActualizado.getPrecio());
                    libro.setLinkReferencia(libroActualizado.getLinkReferencia());
                    libro.setStock(libroActualizado.getStock());
                    return libroRepository.save(libro);
                })
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    public void eliminarLibro(String isbn) {
        libroRepository.deleteById(isbn);
    }
}
