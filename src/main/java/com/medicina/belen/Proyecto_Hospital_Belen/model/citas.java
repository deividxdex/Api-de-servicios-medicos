package com.medicina.belen.Proyecto_Hospital_Belen.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "CITAS")
public class citas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_medico;
    private Long id_paciente;
    private Date fecha_hora;
    private String motivo;
    private String estado;
}
