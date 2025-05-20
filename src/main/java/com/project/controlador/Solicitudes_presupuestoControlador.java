package com.project.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.modelo.Solicitud_presupuesto;
import com.project.servicio.Solicitud_presupuestoServicio;

@RestController
@RequestMapping("/solicitudes")
public class Solicitudes_presupuestoControlador {

	@Autowired
	private Solicitud_presupuestoServicio solicitudPresu;

	@GetMapping
	public ResponseEntity<List<Solicitud_presupuesto>> listarSolicitudes() {
		List<Solicitud_presupuesto> solicitudes = solicitudPresu.listarTodasSolicitudes();
		return new ResponseEntity<>(solicitudes, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Solicitud_presupuesto> crear(@RequestBody Solicitud_presupuesto solicitud) {
		return ResponseEntity.ok(solicitudPresu.crearSolicitud(solicitud));
	}
}
