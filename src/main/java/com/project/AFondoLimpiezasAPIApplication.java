package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


/**
 * Clase main de la aplicacion
 * Anotaciones necesarias para el escaneo de los paquetes: controlador, modelo, repositorio y servicio
 */

@SpringBootApplication
@ComponentScan(basePackages = {
	    "modelo", // Paquete externo con entidades
	    "servicio", // Paquete externo con servicios
	    "controlador"
	})
@EntityScan(basePackages = {
	    "modelo"
	})
@EnableJpaRepositories(basePackages = {
		"repositorio"
	})
public class AFondoLimpiezasAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(AFondoLimpiezasAPIApplication.class, args);
	}

}
