package com.project.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.modelo.Servicio;
import com.project.servicio.ServicioServicio;

@RestController
@RequestMapping("/api/servicios")
public class ServicioControlador {

	@Autowired
	private ServicioServicio servicioServicio;

	@PostMapping("/{solicitudId}")
	public ResponseEntity<Servicio> crearServicio(@PathVariable Long solicitudId, @RequestBody Servicio servicio) {
		return ResponseEntity.ok(servicioServicio.crearServicio(solicitudId, servicio));
	}
}
