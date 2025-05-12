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

	// Guarda usuario
	public Usuario guardarUsuario(Usuario usuario) {
        if(usuario == null) {
            throw new IllegalArgumentException("El usuario no puede ser nulo");
        }
        return usuariorepositorio.save(usuario);
    }

	// Lista todos los usuarios
	public List<Usuario> listarTodosUsuarios() {
        List<Usuario> usuarios = usuariorepositorio.findAll();
        if(usuarios.isEmpty()) {
            throw new RuntimeException("No se encontraron usuarios");
        }
        return usuarios;
    }

	// Encuentra al usuario por el Id
	public Usuario findById(Long id) {
        return usuariorepositorio.findById(id).orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado con ID: " + id));
    }

	// Elimina al usuario por el id
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

	// Modifica parcialmente al usuario
	@Transactional
    public Usuario modificaParcialUsuario(Long id, Map<String, Object> updates) {
        if(updates == null || updates.isEmpty()) {
            throw new IllegalArgumentException("Los campos a actualizar no pueden estar vacíos");
        }

        Usuario usuarioExistente = usuariorepositorio.findById(id)
            .orElseThrow(() -> new UsuarioNoEncontradoException("Usuario no encontrado con ID: " + id));

        updates.forEach((campo, valor) -> {
            try {
                switch (campo) {
                    case "nombre":
                        if(valor != null) usuarioExistente.setNombre(valor.toString());
                        break;
                    case "apellidos":
                        if(valor != null) usuarioExistente.setApellidos(valor.toString());
                        break;
                    case "correo":
                        if(valor != null) {
                            String correo = valor.toString();
                            if(!correo.matches("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                                throw new IllegalArgumentException("Formato de correo inválido");
                            }
                            usuarioExistente.setCorreo(correo);
                        }
                        break;
                    case "direccion":
                        if(valor != null) usuarioExistente.setDireccion(valor.toString());
                        break;
                    case "telefono":
                        if(valor != null) usuarioExistente.setTelefono(valor.toString());
                        break;
                    default:
                        throw new IllegalArgumentException("Campo no permitido para actualización: " + campo);
                }
            } catch (ClassCastException e) {
                throw new IllegalArgumentException("Tipo de dato incorrecto para el campo " + campo);
            }
        });

        return usuariorepositorio.save(usuarioExistente);
    }
	
	//Excepcion personalizada
	class UsuarioNoEncontradoException extends RuntimeException {
	    public UsuarioNoEncontradoException(String mensaje) {
	        super(mensaje);
	        System.out.println(mensaje);
	    }
	}

}
