package com.project.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "asignacion_servicios", schema = "core")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Asignacion_servicio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asignacion_servicio")
	private Long id_asignacion_servicio;

	// TODO: Comentarios de los FK

	@ManyToOne
	@JoinColumn(name = "servicio_id", nullable = false)
	private Servicio servicio;

	@ManyToOne
	@JoinColumn(name = "empleado_id", nullable = false)
	private Empleado empleado;

	private String rol;
}
