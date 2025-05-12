package com.project.modelo;

import java.sql.Date;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "empleados")
public class Empleado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_empleado")
	private Long id_empleado;

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

	@Column(name = "admin")
	private boolean admin;

	@Column(name = "fecha_nac")
	private LocalDate fecha_nac;

	@Column(name = "dni")
	private String dni;

	@Column(name = "contrasenia")
	private String contrasenia;

}