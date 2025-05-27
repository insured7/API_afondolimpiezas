package com.project.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.modelo.Asignacion_servicio;
import com.project.modelo.Empleado;
import com.project.modelo.Servicio;

public interface AsignacionServicioRepositorio extends JpaRepository<Asignacion_servicio, Long> {

	List<Asignacion_servicio> findByEmpleado(Empleado empleado);

	List<Asignacion_servicio> findByServicio(Servicio servicio);

}
