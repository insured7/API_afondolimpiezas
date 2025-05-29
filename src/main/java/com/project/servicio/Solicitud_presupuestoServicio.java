package com.project.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelo.Solicitud_presupuesto;
import com.project.repositorio.Solicitud_presupuestoRepositorio;

@Service
public class Solicitud_presupuestoServicio {

	@Autowired
	Solicitud_presupuestoRepositorio solicitudPresu;

	public List<Solicitud_presupuesto> listarTodas() {
		return solicitudPresu.findAll();
	}

	public Optional<Solicitud_presupuesto> buscarPorId(Long id) {
		return solicitudPresu.findById(id);
	}

	public Solicitud_presupuesto guardar(Solicitud_presupuesto solicitud) {
		return solicitudPresu.save(solicitud);
	}

	public void eliminar(Long id) {
		solicitudPresu.deleteById(id);
	}
}
