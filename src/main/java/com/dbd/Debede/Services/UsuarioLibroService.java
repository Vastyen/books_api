package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.UsuarioLibro;
import com.dbd.Debede.Repositories.UsuarioLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioLibroService {
    private final UsuarioLibroRepository usuarioLibroRepository;

    @Autowired
    public UsuarioLibroService(UsuarioLibroRepository usuarioLibroRepository) {
        this.usuarioLibroRepository = usuarioLibroRepository;
    }

    public List<UsuarioLibro> obtenerTodosLosUsuarioLibros() {
        return usuarioLibroRepository.findAll();
    }

    public UsuarioLibro obtenerUsuarioLibroPorId(Long id) {
        return usuarioLibroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Libro favorito del usuario no encontrado"));
    }

    public UsuarioLibro crearUsuarioLibro(UsuarioLibro usuarioLibro) {
        return usuarioLibroRepository.save(usuarioLibro);
    }

    public UsuarioLibro actualizarUsuarioLibro(Long id, UsuarioLibro usuarioLibroActualizado) {
        return usuarioLibroRepository.findById(id)
                .map(usuarioLibro -> {
                    usuarioLibro.setUsuario(usuarioLibroActualizado.getUsuario());
                    usuarioLibro.setIsbnLibro(usuarioLibroActualizado.getIsbnLibro());
                    return usuarioLibroRepository.save(usuarioLibro);
                })
                .orElseThrow(() -> new RuntimeException("Libro favorito del usuario no encontrado"));
    }

    public void eliminarUsuarioLibro(Long id) {
        usuarioLibroRepository.deleteById(id);
    }
}
