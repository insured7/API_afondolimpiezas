package com.project.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.modelo.Servicio;

public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {
}
