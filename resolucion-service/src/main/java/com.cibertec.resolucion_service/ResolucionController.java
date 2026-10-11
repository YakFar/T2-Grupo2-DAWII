package com.cibertec.resolucion_service;

import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resoluciones")
public class ResolucionController {
    private final ReclamoClient reclamoClient;

    public ResolucionController(ReclamoClient reclamoClient) {
        this.reclamoClient = reclamoClient;
    }

    @PostMapping("/{numero}")
    public ResponseEntity<?> resolver(@PathVariable Long numero, @RequestBody SolicitudResolucion solicitud) {
        if (solicitud.analista() == null || solicitud.analista().isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "Debe indicar el nombre del analista"));
        }
        if (solicitud.estado() == null || (solicitud.estado() != 2 && solicitud.estado() != 3)) {
            return ResponseEntity.badRequest().body(Map.of("mensaje", "El estado debe ser 2 (procedente) o 3 (improcedente)"));
        }
        try {
            ReclamoDto reclamo = reclamoClient.consultar(numero);
            reclamo.setEstado(solicitud.estado());
            reclamo.setAnalista(solicitud.analista());
            reclamo.setObservacion(solicitud.observacion() == null || solicitud.observacion().isBlank()
                    ? (solicitud.estado() == 2 ? "Reclamo procedente" : "Reclamo improcedente")
                    : solicitud.observacion());
            ReclamoDto actualizado = reclamoClient.actualizar(numero, reclamo);
            String estadoTexto = actualizado.getEstado() == 2 ? "procedente" : "improcedente";
            return ResponseEntity.ok(Map.of("mensaje", "Reclamo resuelto como " + estadoTexto,
                    "reclamo", actualizado));
        } catch (feign.FeignException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("mensaje", "No existe el reclamo " + numero));
        } catch (feign.FeignException e) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                    .body(Map.of("mensaje", "No fue posible comunicarse con el servicio de reclamos"));
        }
    }

    public record SolicitudResolucion(Integer estado, String analista, String observacion) { }
}