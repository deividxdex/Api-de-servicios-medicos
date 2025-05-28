package com.medicina.belen.Proyecto_Hospital_Belen.repository;

import com.medicina.belen.Proyecto_Hospital_Belen.model.pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends JpaRepository<pacientes, Long> {
}
