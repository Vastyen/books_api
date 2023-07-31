package com.dbd.Debede.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaccion")
    private Long id;

    @Column(name = "precio_total")
    private Integer precioTotal;

    @Column(name = "medio_de_pago")
    private String medioDePago;

    @ManyToOne
    @JoinColumn(name = "id_carro", referencedColumnName = "id_carro")
    private CarroDeCompras carroDeCompras;

    @Column(name = "estado_transaccion")
    private String estadoTransaccion;
}

