package pe.pagoya.reclamos.api;

import pe.pagoya.reclamos.model.Reclamo;
import pe.pagoya.reclamos.service.ReclamoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamoController {
    private final ReclamoService service;

    public ReclamoController(ReclamoService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<Reclamo> registrar(@RequestBody Reclamo reclamo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(reclamo));
    }

    @GetMapping("/{numero}")
    public ResponseEntity<?> consultar(@PathVariable("numero") Long numero) {
        return service.consultar(numero)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("mensaje", "No existe el reclamo " + numero)));
    }

    @PutMapping("/{numero}")
    public ResponseEntity<?> actualizar(@PathVariable("numero") Long numero, @RequestBody Reclamo cambios) {
        return service.actualizar(numero, cambios)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("mensaje", "No existe el reclamo " + numero)));
    }
}
