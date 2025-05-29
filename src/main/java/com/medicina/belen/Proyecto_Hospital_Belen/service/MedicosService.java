package com.medicina.belen.Proyecto_Hospital_Belen.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface MedicosService {

    public ResponseEntity<Map<String, Object>> listarMedicos();
}
