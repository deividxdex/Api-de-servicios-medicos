package com.medicina.belen.Proyecto_Hospital_Belen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PACIENTES")
public class pacientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fecha_Nacimiento;
    private String talla;
    private String grupo_sanguineo;
    private String direccion;
}
