package com.medicina.belen.Proyecto_Hospital_Belen.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "DISPONIBILIDAD_MEDICA")
public class dis_medica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long id_medico;
    private String dia_semana;
    private String hora_inicio;
    private String hora_fin;

}
