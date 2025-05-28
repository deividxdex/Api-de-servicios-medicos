package com.medicina.belen.Proyecto_Hospital_Belen.repository;

import com.medicina.belen.Proyecto_Hospital_Belen.model.usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<usuarios, Long>{
}
