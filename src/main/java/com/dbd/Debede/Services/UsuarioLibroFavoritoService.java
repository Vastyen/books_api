package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.UsuarioLibroFavorito;
import com.dbd.Debede.Repositories.UsuarioLibroFavoritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioLibroFavoritoService {
    private final UsuarioLibroFavoritoRepository usuarioLibroFavoritoRepository;

    @Autowired
    public UsuarioLibroFavoritoService(UsuarioLibroFavoritoRepository usuarioLibroFavoritoRepository) {
        this.usuarioLibroFavoritoRepository = usuarioLibroFavoritoRepository;
    }

    public List<UsuarioLibroFavorito> obtenerTodosLosUsuarioLibrosFavoritos() {
        return usuarioLibroFavoritoRepository.findAll();
    }

    public UsuarioLibroFavorito obtenerUsuarioLibroFavoritoPorId(Long id) {
        return usuarioLibroFavoritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario libro favorito no encontrado"));
    }

    public UsuarioLibroFavorito crearUsuarioLibroFavorito(UsuarioLibroFavorito usuarioLibroFavorito) {
        return usuarioLibroFavoritoRepository.save(usuarioLibroFavorito);
    }

    public UsuarioLibroFavorito actualizarUsuarioLibroFavorito(Long id, UsuarioLibroFavorito usuarioLibroFavoritoActualizado) {
        return usuarioLibroFavoritoRepository.findById(id)
                .map(usuarioLibroFavorito -> {
                    usuarioLibroFavorito.setUsuario(usuarioLibroFavoritoActualizado.getUsuario());
                    usuarioLibroFavorito.setLibroFavorito(usuarioLibroFavoritoActualizado.getLibroFavorito());
                    return usuarioLibroFavoritoRepository.save(usuarioLibroFavorito);
                })
                .orElseThrow(() -> new RuntimeException("Usuario libro favorito no encontrado"));
    }

    public void eliminarUsuarioLibroFavorito(Long id) {
        usuarioLibroFavoritoRepository.deleteById(id);
    }
}
