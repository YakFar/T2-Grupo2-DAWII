package com.cibertec.resolucion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResolucionServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ResolucionServiceApplication.class, args);
    }
}