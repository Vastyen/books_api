package com.dbd.Debede.Controllers;

import com.dbd.Debede.Entities.CarroDeCompras;
import com.dbd.Debede.Services.CarroDeComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroDeComprasController {
    private final CarroDeComprasService carroDeComprasService;

    @Autowired
    public CarroDeComprasController(CarroDeComprasService carroDeComprasService) {
        this.carroDeComprasService = carroDeComprasService;
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
