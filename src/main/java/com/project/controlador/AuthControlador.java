package com.project.controlador;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AuthRequest;
import com.project.dto.AuthResponse;
import com.project.dto.RegistroUsuarioDTO;
import com.project.dto.RegistroEmpleadoDTO;
import com.project.modelo.Usuario;
import com.project.modelo.Empleado;
import com.project.servicio.AuthServicio;

/**
 * Controlador de autenticación y registro
 */
@RestController
@RequestMapping("/auth")
public class AuthControlador {

	@Autowired
	AuthServicio authServicio;

	// ========== LOGIN ENDPOINTS ==========

	@PostMapping("/login-usuario")
	public ResponseEntity<?> loginUsuario(@RequestBody AuthRequest request) {
		try {
			String token = authServicio.loginUsuario(request.getCorreo(), request.getContrasenia());
			return ResponseEntity.ok(new AuthResponse(token));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas: " + e.getMessage());
		}
	}

	@PostMapping("/login-empleado")
	public ResponseEntity<?> loginEmpleado(@RequestBody AuthRequest request) {
		try {
			String token = authServicio.loginEmpleado(request.getCorreo(), request.getContrasenia());
			return ResponseEntity.ok(new AuthResponse(token));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas: " + e.getMessage());
		}
	}

	// ========== REGISTRO ENDPOINTS ==========

	@PostMapping("/registro-usuario")
	public ResponseEntity<?> registroUsuario(@RequestBody RegistroUsuarioDTO registroDTO) {
		try {
			Usuario nuevoUsuario = authServicio.registrarUsuario(registroDTO);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(Map.of("mensaje", "Usuario registrado exitosamente con ID: " + nuevoUsuario.getId_usuario()));

		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest()
				    .body(Map.of("mensaje", "Error de validación: " + e.getMessage()));

		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.CONFLICT)
				    .body(Map.of("mensaje", "Error en el registro: " + e.getMessage()));

		}
	}

	@PostMapping("/registro-empleado")
	public ResponseEntity<?> registroEmpleado(@RequestBody RegistroEmpleadoDTO registroDTO) {
		try {
			Empleado nuevoEmpleado = authServicio.registrarEmpleado(registroDTO);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body("Empleado registrado exitosamente con ID: " + nuevoEmpleado.getId_empleado());
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().body("Error de validación: " + e.getMessage());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Error en el registro: " + e.getMessage());
		}
	}
}