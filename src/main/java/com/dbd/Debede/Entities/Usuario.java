package com.dbd.Debede.Entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "tabla_usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(nullable = false)
    private String contrasena;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String rol;

    @Column(nullable = false)
    private Integer edad;
}
