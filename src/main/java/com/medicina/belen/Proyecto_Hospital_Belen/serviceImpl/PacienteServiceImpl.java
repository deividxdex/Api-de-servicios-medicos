package com.medicina.belen.Proyecto_Hospital_Belen.serviceImpl;

import com.medicina.belen.Proyecto_Hospital_Belen.model.pacientes;
import com.medicina.belen.Proyecto_Hospital_Belen.repository.PacientesRepository;
import com.medicina.belen.Proyecto_Hospital_Belen.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacientesRepository repository;

    @Override
    public ResponseEntity<Map<String, Object>> listarPacientes() {

        Map<String, Object> response = new HashMap<>();

        try{
            List<pacientes> lista = repository.findAll();

            response.put("success", true);
            response.put("message", "Pacientes listados correctamente");
            response.put("data", lista);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.put("success", false);
            response.put("message", "Error al listar los pacientes: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
