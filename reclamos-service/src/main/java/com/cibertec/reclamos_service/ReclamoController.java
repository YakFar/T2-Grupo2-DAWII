package com.cibertec.reclamos_service;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {
    private final ReclamoRepository repository;

    public ReclamoController(ReclamoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<Reclamo> registrar(@RequestBody Reclamo reclamo) {
        reclamo.setNumreclamo(null);
        if (reclamo.getFechareclamo() == null) reclamo.setFechareclamo(LocalDate.now());
        if (reclamo.getAnalista() == null || reclamo.getAnalista().isBlank()) reclamo.setAnalista("No asignado");
        if (reclamo.getEstado() == null) reclamo.setEstado(1);
        if (reclamo.getObservacion() == null || reclamo.getObservacion().isBlank()) reclamo.setObservacion("por evaluar");
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(reclamo));
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> consultar(@PathVariable Long numero) {
        return repository.findById(numero)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("mensaje", "No existe el reclamo " + numero)));
    }

    @PutMapping("/{numero}")
    public ResponseEntity<?> actualizar(@PathVariable Long numero, @RequestBody Reclamo cambios) {
        return repository.findById(numero).<ResponseEntity<?>>map(actual -> {
            if (cambios.getAnalista() != null) actual.setAnalista(cambios.getAnalista());
            if (cambios.getEstado() != null) actual.setEstado(cambios.getEstado());
            if (cambios.getObservacion() != null) actual.setObservacion(cambios.getObservacion());
            return ResponseEntity.ok(repository.save(actual));
        }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("mensaje", "No existe el reclamo " + numero)));
    }
}