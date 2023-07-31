package com.dbd.Debede.Repositories;

import com.dbd.Debede.Entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion, Long> {
}
