package com.project.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelo.Servicio;
import com.project.repositorio.ServicioRepositorio;
import com.project.repositorio.Solicitud_presupuestoRepositorio;

@Service
public class ServicioServicio {

	@Autowired
	private ServicioRepositorio servicioRepo;

	@Autowired
	private Solicitud_presupuestoRepositorio solicitudRepo;

	public Servicio crearServicio(Servicio servicio) {
		return servicioRepo.save(servicio);
	}

	// Encuentra al servicio por el Id
	public Servicio findById(Long id) {
		return servicioRepo.findById(id).orElseThrow();
	}
}
