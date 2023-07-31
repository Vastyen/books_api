package com.dbd.Debede.Repositories;

import com.dbd.Debede.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByTipoCategoria(String genero);
}
