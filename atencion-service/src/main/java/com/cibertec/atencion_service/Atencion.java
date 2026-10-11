package com.cibertec.atencion_service;

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
@Table(name = "atencion", schema = "atencion")
public class Atencion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String descripcion;
    private String fecha;
    private String estado;
}
