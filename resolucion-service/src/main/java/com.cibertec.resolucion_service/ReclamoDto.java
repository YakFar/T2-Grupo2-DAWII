package com.cibertec.resolucion_service;

import java.time.LocalDate;

public class ReclamoDto {
    private Long numreclamo;
    private LocalDate fechareclamo;
    private String nomcliente;
    private String ultimos4tarjeta;
    private String motivo;
    private String analista;
    private Integer estado;
    private String observacion;

    public Long getNumreclamo() { return numreclamo; }
    public void setNumreclamo(Long numreclamo) { this.numreclamo = numreclamo; }
    public LocalDate getFechareclamo() { return fechareclamo; }
    public void setFechareclamo(LocalDate fechareclamo) { this.fechareclamo = fechareclamo; }
    public String getNomcliente() { return nomcliente; }
    public void setNomcliente(String nomcliente) { this.nomcliente = nomcliente; }
    public String getUltimos4tarjeta() { return ultimos4tarjeta; }
    public void setUltimos4tarjeta(String ultimos4tarjeta) { this.ultimos4tarjeta = ultimos4tarjeta; }
    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }
    public String getAnalista() { return analista; }
    public void setAnalista(String analista) { this.analista = analista; }
    public Integer getEstado() { return estado; }
    public void setEstado(Integer estado) { this.estado = estado; }
    public String getObservacion() { return observacion; }
    public void setObservacion(String observacion) { this.observacion = observacion; }
}