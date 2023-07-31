package com.dbd.Debede.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long id;

    @Column(name = "restriccion_edad")
    private Boolean restriccionEdad;

    @Column(name = "tipo_categoria")
    private String tipoCategoria;

    @Column(name = "ubicacion_geografica")
    private String ubicacionGeografica;
}
