package com.project.controlador;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.modelo.Empleado;
import com.project.modelo.Solicitud_presupuesto;
import com.project.servicio.EmpleadoServicio;
import com.project.servicio.Solicitud_presupuestoServicio;

import ch.qos.logback.core.model.Model;

@RestController
@RequestMapping("/admin")
public class AdminControlador {

	@Autowired 
	EmpleadoServicio es = new EmpleadoServicio();
	@Autowired
	
	
	Solicitud_presupuestoServicio Soli = new Solicitud_presupuestoServicio();
	
	/*
	 * public String dashboardAdmin(Model model, Principal principal) { String email
	 * = principal.getName();
	 * 
	 * // Obtener datos personales del admin Empleado admin =
	 * es.buscarPorCorreo(email);
	 * 
	 * // Obtener panel de control con solicitudes (todas o filtradas)
	 * List<Solicitud_presupuesto> solicitudes = Soli.obtenerSolicitudesParaAdmin();
	 * 
	 * model.addAttribute("admin", admin); model.addAttribute("solicitudes",
	 * solicitudes);
	 * 
	 * return "admin/dashboard-admin"; // JSP para admin }
	 */
}
