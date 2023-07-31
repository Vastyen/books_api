package com.dbd.Debede.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "libro_categoria")
public class LibroCategoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro_categoria")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "isbn_libro", referencedColumnName = "isbn")
    private Libro libro;
}

