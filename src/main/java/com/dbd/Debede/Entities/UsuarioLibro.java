package com.dbd.Debede.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "usuario_libro")
public class UsuarioLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro_favorito")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @Column(name = "isbn_libro")
    private String isbnLibro;
}
