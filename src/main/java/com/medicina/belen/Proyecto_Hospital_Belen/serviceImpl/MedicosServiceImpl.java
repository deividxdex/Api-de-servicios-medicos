package com.medicina.belen.Proyecto_Hospital_Belen.serviceImpl;

import com.medicina.belen.Proyecto_Hospital_Belen.model.medicos;
import com.medicina.belen.Proyecto_Hospital_Belen.repository.MedicosRepository;
import com.medicina.belen.Proyecto_Hospital_Belen.service.MedicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedicosServiceImpl implements MedicosService {

    @Autowired
    private MedicosRepository repository;

    @Override
    public ResponseEntity<Map<String, Object>> listarMedicos() {

        Map<String, Object> response = new HashMap<>();

        try {
            List<medicos> lista = repository.findAll();

            response.put("succes", true);
            response.put("message", "Medicos Listados correctamente");
            response.put("data", lista);
            return ResponseEntity.ok(response);
        }catch (Exception e){
            response.put("succes", false);
            response.put("message", "Error al listar los medicos" + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
