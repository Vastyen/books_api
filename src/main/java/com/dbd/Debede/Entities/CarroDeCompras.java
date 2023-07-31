package com.dbd.Debede.Entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "carro_de_compras")
public class CarroDeCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carro")
    private Long id;

    @Column(name = "precio_total")
    private Integer precioTotal;

    @Column(name = "cantidad_productos")
    private Integer cantidadProductos;

    @Column(name = "stock_check")
    private Boolean stockCheck;

    @Column(name = "productos")
    private String productos;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
}
