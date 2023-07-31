package com.dbd.Debede.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "autor")
    private String autor;

    @Column(name = "visualizaciones")
    private Integer visualizaciones;

    @Column(name = "precio")
    private Integer precio;

    @Column(name = "link_referencia")
    private String linkReferencia;

    @Column(name = "stock")
    private Boolean stock;
}
