package com.vacaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.modelos.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
	
}