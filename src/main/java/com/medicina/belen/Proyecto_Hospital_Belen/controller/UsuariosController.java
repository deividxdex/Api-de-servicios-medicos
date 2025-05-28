package com.medicina.belen.Proyecto_Hospital_Belen.controller;

import com.medicina.belen.Proyecto_Hospital_Belen.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService service;

    @GetMapping
    public ResponseEntity<Map<String, Object>> listarUsuarios(){
        try{
            return service.listarUsuarios();
        }catch (Exception e){
            System.out.println("Error econtrado: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
