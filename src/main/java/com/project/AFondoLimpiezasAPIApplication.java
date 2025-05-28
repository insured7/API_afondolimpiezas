package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Aplicacion main de Spring, donde se iniciará todo.
 * 
 */
@SpringBootApplication
public class AFondoLimpiezasAPIApplication {

	public static void main(String[] args) {
		SpringApplication.run(AFondoLimpiezasAPIApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/**")
	                .allowedOrigins("http://localhost:4200", "http://localhost:3000") // Añadir más orígenes
	                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
	                .allowedHeaders("*")
	                .allowCredentials(true);
	        }
	    };
	}
}