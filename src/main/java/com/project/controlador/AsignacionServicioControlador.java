package com.project.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.modelo.Asignacion_servicio;
import com.project.servicio.AsignacionServicioServicio;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionServicioControlador {

	@Autowired
	private AsignacionServicioServicio asignacionServicio;

	@PostMapping
	public ResponseEntity<Asignacion_servicio> asignarEmpleado(@RequestParam Long servicioId,
			@RequestParam Long empleadoId, @RequestParam String rol) {
		return ResponseEntity.ok(asignacionServicio.asignarEmpleado(servicioId, empleadoId, rol));
	}
}
