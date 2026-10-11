package pe.pagoya.reclamos.service;

import pe.pagoya.reclamos.model.Reclamo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ReclamoService {
    private final AtomicLong secuencia = new AtomicLong(1000);
    private final ConcurrentHashMap<Long, Reclamo> reclamos = new ConcurrentHashMap<>();

    public Reclamo registrar(Reclamo entrada) {
        long numero = secuencia.incrementAndGet();
        Reclamo nuevo = new Reclamo(numero,
                entrada.getFechareclamo() == null ? LocalDate.now() : entrada.getFechareclamo(),
                entrada.getNomcliente(), entrada.getUltimos4tarjeta(), entrada.getMotivo(),
                entrada.getAnalista(), entrada.getEstado(), entrada.getObservacion());
        reclamos.put(numero, nuevo);
        return nuevo;
    }

    public Optional<Reclamo> consultar(Long numero) { return Optional.ofNullable(reclamos.get(numero)); }

    public Optional<Reclamo> actualizar(Long numero, Reclamo cambios) {
        return Optional.ofNullable(reclamos.computeIfPresent(numero, (id, actual) -> {
            if (cambios.getAnalista() != null) actual.setAnalista(cambios.getAnalista());
            if (cambios.getEstado() != null) actual.setEstado(cambios.getEstado());
            if (cambios.getObservacion() != null) actual.setObservacion(cambios.getObservacion());
            return actual;
        }));
    }
}
