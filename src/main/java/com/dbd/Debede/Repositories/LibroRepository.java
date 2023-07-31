package com.dbd.Debede.Repositories;

import com.dbd.Debede.Entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, String> {
}
