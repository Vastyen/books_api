package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.LibroFavorito;
import com.dbd.Debede.Repositories.LibroFavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroFavoritoService {
    private final LibroFavoritoRepository libroFavoritoRepository;

    @Autowired
    public LibroFavoritoService(LibroFavoritoRepository libroFavoritoRepository) {
        this.libroFavoritoRepository = libroFavoritoRepository;
    }

    public List<LibroFavorito> obtenerTodosLosLibrosFavoritos() {
        return libroFavoritoRepository.findAll();
    }

    public LibroFavorito obtenerLibroFavoritoPorId(Long id) {
        return libroFavoritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro favorito no encontrado"));
    }

    public LibroFavorito crearLibroFavorito(LibroFavorito libroFavorito) {
        return libroFavoritoRepository.save(libroFavorito);
    }

    public LibroFavorito actualizarLibroFavorito(Long id, LibroFavorito libroFavoritoActualizado) {
        return libroFavoritoRepository.findById(id)
                .map(libroFavorito -> {
                    libroFavorito.setUsuario(libroFavoritoActualizado.getUsuario());
                    libroFavorito.setLibro(libroFavoritoActualizado.getLibro());
                    return libroFavoritoRepository.save(libroFavorito);
                })
                .orElseThrow(() -> new RuntimeException("Libro favorito no encontrado"));
    }

    public void eliminarLibroFavorito(Long id) {
        libroFavoritoRepository.deleteById(id);
    }
}
