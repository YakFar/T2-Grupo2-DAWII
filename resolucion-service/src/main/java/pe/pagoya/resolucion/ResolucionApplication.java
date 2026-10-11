package pe.pagoya.resolucion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResolucionApplication {
    public static void main(String[] args) { SpringApplication.run(ResolucionApplication.class, args); }
}
