package com.project.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.dto.AuthRequest;
import com.project.dto.AuthResponse;
import com.project.servicio.AuthServicio;

/**
 * Controlador del Login de la pagina, autorizado por tokens
 */
@RestController
@RequestMapping("/auth")
public class AuthControlador {

	@Autowired
	AuthServicio authServicio;
	
	@PostMapping("/login-usuario")
    public ResponseEntity<?> loginUsuario(@RequestBody AuthRequest request) {
        String token = authServicio.loginUsuario(request.getCorreo(), request.getContrasenia());
        return ResponseEntity.ok(new AuthResponse(token));
    }

    @PostMapping("/login-empleado")
    public ResponseEntity<?> loginEmpleado(@RequestBody AuthRequest request) {
        String token = authServicio.loginEmpleado(request.getCorreo(), request.getContrasenia());
        return ResponseEntity.ok(new AuthResponse(token));
    }
	
}
