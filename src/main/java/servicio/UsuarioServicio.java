package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.Usuario;
import repositorio.UsuarioRepositorio;

/**
 * Servicio que se encarga de la logica de los usuarios
 */


@Service
public class UsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuariorepositorio;
	
	public Usuario guardarUsuario(Usuario usuario) {
        return usuariorepositorio.save(usuario);
    }

    public List<Usuario> listarTodosUsuarios() {
        return usuariorepositorio.findAll();
    }
    
}
