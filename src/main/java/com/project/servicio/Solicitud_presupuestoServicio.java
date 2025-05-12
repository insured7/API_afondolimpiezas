package com.project.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.modelo.Solicitud_presupuesto;
import com.project.repositorio.Solicitud_presupuestoRepositorio;

@Service
public class Solicitud_presupuestoServicio {

	
	@Autowired
	Solicitud_presupuestoRepositorio solicitudPresu;
	
	public List<Solicitud_presupuesto> listarTodasSolicitudes() {
        return solicitudPresu.findAll();
    }
}
