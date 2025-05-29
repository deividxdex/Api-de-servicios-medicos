package com.medicina.belen.Proyecto_Hospital_Belen.service;

import org.springframework.http.ResponseEntity;

import javax.management.ObjectName;
import java.util.Map;

public interface PacienteService {

    public ResponseEntity<Map<String, Object>> listarPacientes();
}
