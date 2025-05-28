package com.medicina.belen.Proyecto_Hospital_Belen.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface UsuariosService {

    public ResponseEntity<Map<String, Object>> listarUsuarios();
}
