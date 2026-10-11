package pe.pagoya.reclamos.model;

import java.time.LocalDate;

public class Reclamo {
    private Long numreclamo;
    private LocalDate fechareclamo;
    private String nomcliente;
    private String ultimos4tarjeta;
    private String motivo;
    private String analista = "No asignado";
    private Integer estado = 1;
    private String observacion = "por evaluar";

    public Reclamo() { }

    public Reclamo(Long numreclamo, LocalDate fechareclamo, String nomcliente, String ultimos4tarjeta,
                   String motivo, String analista, Integer estado, String observacion) {
        this.numreclamo = numreclamo;
        this.fechareclamo = fechareclamo;
        this.nomcliente = nomcliente;
        this.ultimos4tarjeta = ultimos4tarjeta;
        this.motivo = motivo;
        this.analista = analista == null || analista.isBlank() ? "No asignado" : analista;
        this.estado = estado == null ? 1 : estado;
        this.observacion = observacion == null || observacion.isBlank() ? "por evaluar" : observacion;
    }

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
