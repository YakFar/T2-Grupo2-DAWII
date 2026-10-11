package pe.pagoya.resolucion.client;

import pe.pagoya.resolucion.dto.ReclamoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "servicio-reclamos")
public interface ReclamoClient {
    @GetMapping("/api/reclamos/{numero}")
    ReclamoDto consultar(@PathVariable("numero") Long numero);

    @PutMapping("/api/reclamos/{numero}")
    ReclamoDto actualizar(@PathVariable("numero") Long numero, @RequestBody ReclamoDto reclamo);
}
