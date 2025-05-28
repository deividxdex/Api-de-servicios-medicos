package com.medicina.belen.Proyecto_Hospital_Belen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "MEDICOS")
public class medicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String especialidad;
    private String numero_colegiado;
    private String codigo_medico_hospital;
}
