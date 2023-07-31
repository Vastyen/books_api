package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.LibroCategoria;
import com.dbd.Debede.Repositories.LibroCategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroCategoriaService {
    private final LibroCategoriaRepository libroCategoriaRepository;

    @Autowired
    public LibroCategoriaService(LibroCategoriaRepository libroCategoriaRepository) {
        this.libroCategoriaRepository = libroCategoriaRepository;
    }

    public List<LibroCategoria> obtenerTodosLosLibrosCategorias() {
        return libroCategoriaRepository.findAll();
    }

    public LibroCategoria obtenerLibroCategoriaPorId(Long id) {
        return libroCategoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría de libro no encontrada"));
    }

    public LibroCategoria crearLibroCategoria(LibroCategoria libroCategoria) {
        return libroCategoriaRepository.save(libroCategoria);
    }

    public LibroCategoria actualizarLibroCategoria(Long id, LibroCategoria libroCategoriaActualizada) {
        return libroCategoriaRepository.findById(id)
                .map(libroCategoria -> {
                    libroCategoria.setCategoria(libroCategoriaActualizada.getCategoria());
                    libroCategoria.setLibro(libroCategoriaActualizada.getLibro());
                    return libroCategoriaRepository.save(libroCategoria);
                })
                .orElseThrow(() -> new RuntimeException("Categoría de libro no encontrada"));
    }

    public void eliminarLibroCategoria(Long id) {
        libroCategoriaRepository.deleteById(id);
    }
}
