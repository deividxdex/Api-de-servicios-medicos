package com.medicina.belen.Proyecto_Hospital_Belen.serviceImpl;

import com.medicina.belen.Proyecto_Hospital_Belen.model.citas;
import com.medicina.belen.Proyecto_Hospital_Belen.repository.CitasRepository;
import com.medicina.belen.Proyecto_Hospital_Belen.service.CitasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CitasServiceImpl implements CitasService {

    @Autowired
    private CitasRepository repository;

    @Override
    public ResponseEntity<Map<String, Object>> listarCitas() {

        Map<String, Object> response = new HashMap<>();

        try{
            List<citas> lista = repository.findAll();

            response.put("success", true);
            response.put("message", "Citas listadas correctamente");
            response.put("data", lista);
            return ResponseEntity.ok(response);
        } catch (Exception e){
            response.put("success", false);
            response.put("message", "Error al listar las citas: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> crearCita(citas cita) {
        Map<String, Object> response = new HashMap<>();
        try {
            cita.setEstado("activa"); // Estado inicial
            citas nueva = repository.save(cita);
            response.put("success", true);
            response.put("message", "Cita creada exitosamente");
            response.put("data", nueva);
            return ResponseEntity.status(201).body(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al crear la cita: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> actualizarCita(Long id, citas cita) {
        Map<String, Object> response = new HashMap<>();

        try {
            citas existente = repository.findById(id).orElse(null);

            if (existente == null) {
                response.put("success", false);
                response.put("message", "Cita no encontrada");
                return ResponseEntity.status(404).body(response);
            }

            existente.setId_medico(cita.getId_medico());
            existente.setId_paciente(cita.getId_paciente());
            existente.setFecha_hora(cita.getFecha_hora());
            existente.setMotivo(cita.getMotivo());

            repository.save(existente);

            response.put("success", true);
            response.put("message", "Cita actualizada exitosamente");
            response.put("data", existente);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al actualizar la cita: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> cancelarCita(Long id) {
        Map<String, Object> response = new HashMap<>();
        try {
            citas cita = repository.findById(id).orElse(null);
            if (cita == null) {
                response.put("success", false);
                response.put("message", "Cita no encontrada");
                return ResponseEntity.status(404).body(response);
            }

            cita.setEstado("cancelada");
            repository.save(cita);

            response.put("success", true);
            response.put("message", "Cita cancelada exitosamente");
            response.put("data", cita);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al cancelar la cita: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

}
