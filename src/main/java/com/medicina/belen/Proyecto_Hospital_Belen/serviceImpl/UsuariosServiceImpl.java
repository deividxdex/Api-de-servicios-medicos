package com.medicina.belen.Proyecto_Hospital_Belen.serviceImpl;

import com.medicina.belen.Proyecto_Hospital_Belen.model.usuarios;
import com.medicina.belen.Proyecto_Hospital_Belen.repository.UsuariosRepository;
import com.medicina.belen.Proyecto_Hospital_Belen.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UsuariosServiceImpl implements UsuariosService {

    @Autowired
    private UsuariosRepository repository;

    @Override
    public ResponseEntity<Map<String, Object>> listarUsuarios() {

        Map<String, Object> response = new HashMap<>();

        try {
            List<usuarios> lista = repository.findAll();

            response.put("success", true);
            response.put("message", "Usuarios listados correctamente");
            response.put("data", lista);
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error al listar los usuarios: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }

    public usuarios crearUsuario(usuarios usuario) {
        if (!usuario.getRol().equalsIgnoreCase("paciente") &&
                !usuario.getRol().equalsIgnoreCase("medico")) {
            throw new IllegalArgumentException("Rol no válido. Debe ser 'paciente' o 'medico'.");
        }
        return repository.save(usuario);
    }

}
