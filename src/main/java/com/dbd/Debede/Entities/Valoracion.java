package com.dbd.Debede.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "valoracion")
public class Valoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valoracion")
    private Long id;

    @Column(name = "puntuacion")
    private Integer puntuacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(name = "isbn_libro")
    private String isbnLibro;
}
