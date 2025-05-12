package com.project.servicio;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project.modelo.Usuario;
import com.project.repositorio.UsuarioRepositorio;

import jakarta.transaction.Transactional;

/**
 * Servicio que se encarga de la logica de los usuarios
 */

@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuariorepositorio;

	// Create
	public Usuario guardarUsuario(Usuario usuario) {
		return usuariorepositorio.save(usuario);
	}

	// Read
	public List<Usuario> listarTodosUsuarios() {
		return usuariorepositorio.findAll();
	}

	// Read by Id
	public Optional<Usuario> findById(Long id) {
		return usuariorepositorio.findById(id);
	}

	// Delete by Id
	public ResponseEntity<String> deletebyId(Long id) {

		if (usuariorepositorio.existsById(id)) {
			System.out.println("Usuario eliminado correctamente.");
			usuariorepositorio.deleteById(id);
			return ResponseEntity.ok("Usuario eliminado correctamente.");
		} else {
			System.out.println("Usuario no encontrado.");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
		}
	}

	// Update parcial
	@Transactional
	public Usuario updateParcialUsuario(Long id, Map<String, Object> updates) {

		Usuario usuarioExistente = usuariorepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

		updates.forEach((campo, valor) -> {
			switch (campo) {
			case "nombre":
				usuarioExistente.setNombre((String) valor);
				break;

			case "apellidos":
				usuarioExistente.setApellidos((String) valor);

			case "email":
				usuarioExistente.setEmail((String) valor);
				break;
			case "direccion":
				usuarioExistente.setDireccion((String) valor);
				break;
			case "telefono":
				usuarioExistente.setTelefono((String) valor);
				break;
			}
		});

		return usuariorepositorio.save(usuarioExistente);
	}

}
