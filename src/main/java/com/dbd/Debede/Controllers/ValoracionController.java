package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.Usuario;
import com.dbd.Debede.Entities.Valoracion;
import com.dbd.Debede.Repositories.UsuarioRepository;
import com.dbd.Debede.Services.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {

    private final UsuarioRepository usuarioRepository;

    private final ValoracionService valoracionService;

    @Autowired
    public ValoracionController(UsuarioRepository usuarioRepository, ValoracionService valoracionService) {
        this.usuarioRepository = usuarioRepository;
        this.valoracionService = valoracionService;
    }

    @GetMapping
    public List<Valoracion> obtenerTodasLasValoraciones() {
        return valoracionService.obtenerTodasLasValoraciones();
    }

    @GetMapping("/{id}")
    public Valoracion obtenerValoracionPorId(@PathVariable Long id) {
        return valoracionService.obtenerValoracionPorId(id);
    }

    @PostMapping
    public Valoracion crearValoracion(@RequestBody Valoracion valoracion) {
        // Obtiene el usuario de la valoración
        Usuario usuario = valoracion.getUsuario();

        // Verifica si el usuario es nuevo o ya existe en la base de datos
        if (usuario.getId() == null) {
            // Si el usuario es nuevo, puedes establecer valores predeterminados para los campos requeridos
                usuario.setNombre("NombrePredeterminado");
            usuario.setApellido("ApellidoPredeterminado");
            usuario.setContrasena("contrasenaPredeterminada");
            usuario.setRol("rolPredeterminada");
            usuario.setEdad(0);

        }

        // Guarda el usuario antes de crear la valoración
        usuarioRepository.save(usuario);

        // Luego, crea la valoración con el usuario guardado
        return valoracionService.crearValoracion(valoracion);
    }
    @PutMapping("/{id}")
    public Valoracion actualizarValoracion(@PathVariable Long id, @RequestBody Valoracion valoracionActualizada) {
        return valoracionService.actualizarValoracion(id, valoracionActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarValoracion(@PathVariable Long id) {
        valoracionService.eliminarValoracion(id);
    }
}
