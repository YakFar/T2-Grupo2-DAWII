package com.cibertec.reclamos_service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reclamo", schema = "atencion")
public class Reclamo implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  private Long id;
  private String descripcion;
  private String fecha;
  private String estado;
}
