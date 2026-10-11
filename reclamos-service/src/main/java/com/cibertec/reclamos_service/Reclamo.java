package com.cibertec.reclamos_service;

import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reclamo", schema = "atencion")
public class Reclamo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long numreclamo;
  private LocalDate fechareclamo;
  private String nomcliente;
  private String ultimos4tarjeta;
  private String motivo;
  private String analista = "No asignado";
  private Integer estado = 1;
  private String observacion = "por evaluar";
}