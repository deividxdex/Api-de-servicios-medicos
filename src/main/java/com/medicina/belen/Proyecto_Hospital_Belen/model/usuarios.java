package com.medicina.belen.Proyecto_Hospital_Belen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String apellido;
    private String sexo;
    private String telefono;
    private String email;
    private String contrasena;
    private String rol;
}
