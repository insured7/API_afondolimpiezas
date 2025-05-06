package servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modelo.Empleado;
import modelo.Usuario;
import repositorio.EmpleadoRepositorio;

@Service
public class EmpleadoServicio {

	
	@Autowired
	public EmpleadoRepositorio empRepo;
	
	public Empleado guardarEmpleado(Empleado empleado) {
        return empRepo.save(empleado);
    }

    public List<Empleado> listarTodosEmpleados() {
        return empRepo.findAll();
    }
}
