package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import modelo.Usuario;
import servicio.UsuarioServicio;

/**
 * Endpoint de usuarios
 */

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {

	@Autowired
	private UsuarioServicio usuarioservicio;
	
	@PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {
        Usuario nuevoUsuario = usuarioservicio.guardarUsuario(usuario);
        return new ResponseEntity<>(nuevoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        List<Usuario> usuarios = usuarioservicio.listarTodosUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
}
