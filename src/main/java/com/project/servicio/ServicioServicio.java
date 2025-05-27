package com.project.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelo.Servicio;
import com.project.modelo.Solicitud_presupuesto;
import com.project.modelo.Usuario;
import com.project.repositorio.ServicioRepositorio;
import com.project.repositorio.Solicitud_presupuestoRepositorio;
import com.project.servicio.UsuarioServicio.UsuarioNoEncontradoException;

@Service
public class ServicioServicio {

	@Autowired
	private ServicioRepositorio servicioRepo;

	@Autowired
	private Solicitud_presupuestoRepositorio solicitudRepo;

	public Servicio crearServicio(Long solicitudId, Servicio servicio) {
		Solicitud_presupuesto solicitud = solicitudRepo.findById(solicitudId)
				.orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
		servicio.setSolicitud(solicitud);
		return servicioRepo.save(servicio);
	}
	
	// Encuentra al servicio por el Id
		public Servicio findById(Long id) {
	        return servicioRepo.findById(id).orElseThrow();
	    }
}
