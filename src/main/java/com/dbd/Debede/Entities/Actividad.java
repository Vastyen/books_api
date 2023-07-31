package com.dbd.Debede.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad")
    private Long id;

    @Column(name = "cantidad_libros_publicados")
    private Integer cantidadLibrosPublicados;

    @Column(name = "promedio_libros_publicados")
    private Integer promedioLibrosPublicados;

    @Column(name = "desviacion_libros_publicados")
    private Integer desviacionLibrosPublicados;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;
}
