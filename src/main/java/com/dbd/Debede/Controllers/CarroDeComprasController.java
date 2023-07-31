package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.CarroDeCompras;
import com.dbd.Debede.Entities.Usuario;
import com.dbd.Debede.Repositories.UsuarioRepository;
import com.dbd.Debede.Services.CarroDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroDeComprasController {
    private final CarroDeComprasService carroDeComprasService;
    private final UsuarioRepository usuarioRepository;


    @Autowired
    public CarroDeComprasController(CarroDeComprasService carroDeComprasService, UsuarioRepository usuarioRepository) {
        this.carroDeComprasService = carroDeComprasService;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<CarroDeCompras> obtenerTodosLosCarrosDeCompras() {
        return carroDeComprasService.obtenerTodosLosCarrosDeCompras();
    }

    @GetMapping("/{id}")
    public CarroDeCompras obtenerCarroDeComprasPorId(@PathVariable Long id) {
        return carroDeComprasService.obtenerCarroDeComprasPorId(id);
    }

    @PostMapping
    public CarroDeCompras crearCarroDeCompras(@RequestBody CarroDeCompras carroDeCompras) {
        Usuario usuario = carroDeCompras.getUsuario();

        // Verifica si el usuario es nuevo o ya existe en la base de datos
        if (usuario.getId() != null) {
            // Si el usuario es nuevo, puedes establecer valores predeterminados para los campos requeridos
            usuario.setNombre("NombrePredeterminado");
            usuario.setApellido("ApellidoPredeterminado");
            usuario.setContrasena("contrasenaPredeterminada");
            usuario.setRol("rolPredeterminada");
            usuario.setEdad(0);
        }

        // Guarda el usuario antes de crear la valoración
        usuarioRepository.save(usuario);

        return carroDeComprasService.crearCarroDeCompras(carroDeCompras);
    }

    @PutMapping("/{id}")
    public CarroDeCompras actualizarCarroDeCompras(@PathVariable Long id, @RequestBody CarroDeCompras carroActualizado) {
        return carroDeComprasService.actualizarCarroDeCompras(id, carroActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarCarroDeCompras(@PathVariable Long id) {
        carroDeComprasService.eliminarCarroDeCompras(id);
    }
}
