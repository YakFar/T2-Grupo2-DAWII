package com.cibertec.resolucion_service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "reclamos-service")
public interface ReclamoClient {
    @GetMapping("/api/reclamos/{numero}")
    ReclamoDto consultar(@PathVariable("numero") Long numero);

    @PutMapping("/api/reclamos/{numero}")
    ReclamoDto actualizar(@PathVariable("numero") Long numero, @RequestBody ReclamoDto reclamo);
}