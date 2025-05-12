package com.project.modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;

/**
 * Entidad usuario
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios", schema = "core")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id_usuario;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellidos")
	private String apellidos;
	@Column(name = "correo")
	private String correo;
	@Column(name = "direccion")
	private String direccion;
	@Column(name = "telefono")
	private String telefono;
	@Column(name = "contrasenia")
	private String contrasenia;

	
	@OneToMany(mappedBy = "usuario")
	@JsonManagedReference
	@JsonIgnore
	private List<Solicitud_presupuesto> solicitudes;

}
