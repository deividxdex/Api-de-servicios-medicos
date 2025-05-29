package com.medicina.belen.Proyecto_Hospital_Belen.service;

import com.medicina.belen.Proyecto_Hospital_Belen.model.citas;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface CitasService {
    public ResponseEntity<Map<String, Object>> listarCitas();
    public ResponseEntity<Map<String, Object>> crearCita(citas cita);
    public ResponseEntity<Map<String, Object>> actualizarCita(Long id, citas cita);
    public ResponseEntity<Map<String, Object>> cancelarCita(Long id);
}
