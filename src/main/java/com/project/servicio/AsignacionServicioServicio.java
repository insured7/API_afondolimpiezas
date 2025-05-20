package com.project.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelo.Asignacion_servicio;
import com.project.modelo.Empleado;
import com.project.modelo.Servicio;
import com.project.repositorio.AsignacionServicioRepositorio;
import com.project.repositorio.EmpleadoRepositorio;
import com.project.repositorio.ServicioRepositorio;

@Service
public class AsignacionServicioServicio {

	@Autowired
	private AsignacionServicioRepositorio asignacionRepo;

	@Autowired
	private ServicioRepositorio servicioRepo;

	@Autowired
	private EmpleadoRepositorio empleadoRepo;

	public Asignacion_servicio asignarEmpleado(Long servicioId, Long empleadoId, String rol) {
		Servicio servicio = servicioRepo.findById(servicioId)
				.orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

		Empleado empleado = empleadoRepo.findById(empleadoId)
				.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

		Asignacion_servicio asignacion = new Asignacion_servicio();
		asignacion.setServicio(servicio);
		asignacion.setEmpleado(empleado);
		asignacion.setRol(rol);

		return asignacionRepo.save(asignacion);
	}
}
