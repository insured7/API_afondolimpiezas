package repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import modelo.Empleado;

/**
 * Repositorio de empleado
 */
@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {

}
