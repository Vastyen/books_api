package com.dbd.Debede.Services;

import com.dbd.Debede.Entities.CarroDeCompras;
import com.dbd.Debede.Repositories.CarroDeComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroDeComprasService {
    private final CarroDeComprasRepository carroDeComprasRepository;

    @Autowired
    public CarroDeComprasService(CarroDeComprasRepository carroDeComprasRepository) {
        this.carroDeComprasRepository = carroDeComprasRepository;
    }

    public List<CarroDeCompras> obtenerTodosLosCarrosDeCompras() {
        return carroDeComprasRepository.findAll();
    }

    public CarroDeCompras obtenerCarroDeComprasPorId(Long id) {
        return carroDeComprasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carro de compras no encontrado"));
    }

    public CarroDeCompras crearCarroDeCompras(CarroDeCompras carroDeCompras) {
        return carroDeComprasRepository.save(carroDeCompras);
    }

    public CarroDeCompras actualizarCarroDeCompras(Long id, CarroDeCompras carroActualizado) {
        return carroDeComprasRepository.findById(id)
                .map(carro -> {
                    carro.setPrecioTotal(carroActualizado.getPrecioTotal());
                    carro.setCantidadProductos(carroActualizado.getCantidadProductos());
                    carro.setStockCheck(carroActualizado.getStockCheck());
                    carro.setProductos(carroActualizado.getProductos());
                    carro.setUsuario(carroActualizado.getUsuario());
                    return carroDeComprasRepository.save(carro);
                })
                .orElseThrow(() -> new RuntimeException("Carro de compras no encontrado"));
    }

    public void eliminarCarroDeCompras(Long id) {
        carroDeComprasRepository.deleteById(id);
    }
}
