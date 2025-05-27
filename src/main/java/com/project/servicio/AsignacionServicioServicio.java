package com.project.servicio;

import java.util.List;

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

	// Asigna un empleado a un servicio con un rol determinado
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

	// Devuelve todas las asignaciones
	public List<Asignacion_servicio> obtenerTodasAsignaciones() {
		return asignacionRepo.findAll();
	}

	// Obtiene las asignaciones de un empleado específico
	public List<Asignacion_servicio> obtenerAsignacionesPorEmpleado(Long empleadoId) {
		Empleado empleado = empleadoRepo.findById(empleadoId)
				.orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
		return asignacionRepo.findByEmpleado(empleado);
	}

	// Obtiene las asignaciones de un servicio específico
	public List<Asignacion_servicio> obtenerAsignacionesPorServicio(Long servicioId) {
		Servicio servicio = servicioRepo.findById(servicioId)
				.orElseThrow(() -> new RuntimeException("Servicio no encontrado"));
		return asignacionRepo.findByServicio(servicio);
	}

	// Elimina una asignación por su ID
	public void eliminarAsignacion(Long idAsignacion) {
		if (!asignacionRepo.existsById(idAsignacion)) {
			throw new RuntimeException("Asignación no encontrada");
		}
		asignacionRepo.deleteById(idAsignacion);
	}

	// Actualiza el rol de una asignación existente
	public Asignacion_servicio actualizarRolAsignacion(Long idAsignacion, String nuevoRol) {
		Asignacion_servicio asignacion = asignacionRepo.findById(idAsignacion)
				.orElseThrow(() -> new RuntimeException("Asignación no encontrada"));
		asignacion.setRol(nuevoRol);
		return asignacionRepo.save(asignacion);
	}

}
