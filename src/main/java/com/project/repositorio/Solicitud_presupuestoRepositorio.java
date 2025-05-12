package com.project.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.modelo.Solicitud_presupuesto;

@Repository
public interface Solicitud_presupuestoRepositorio extends JpaRepository<Solicitud_presupuesto, Long> {

}
