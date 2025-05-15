package com.project.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.modelo.Empleado;
import com.project.modelo.Usuario;
import com.project.repositorio.EmpleadoRepositorio;
import com.project.repositorio.UsuarioRepositorio;
import com.project.util.JwtUtil;


/**
 * Clase Servicio de Login
 * Compara correo y contraseña y genera un token con el correo y el ROL.
 */
@Service
public class AuthServicio {

	@Autowired
	UsuarioRepositorio usuRep;

	@Autowired
	EmpleadoRepositorio empRep;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public String loginUsuario(String correo, String contrasenia) {
		
        Usuario u = usuRep.findByCorreo(correo)
            .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        if (!passwordEncoder.matches(contrasenia, u.getContrasenia())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        return JwtUtil.generateToken(correo, "USUARIO");
    }
	
	public String loginEmpleado(String correo, String contrasenia) {
        Empleado e = empRep.findByCorreo(correo)
            .orElseThrow(() -> new UsernameNotFoundException("Empleado no encontrado"));

        if (!passwordEncoder.matches(contrasenia, e.getContrasenia())) {
            throw new BadCredentialsException("Contraseña incorrecta");
        }

        String rol = e.isAdmin() ? "ADMIN" : "EMPLEADO";

        return JwtUtil.generateToken(correo, rol);
    }

}
