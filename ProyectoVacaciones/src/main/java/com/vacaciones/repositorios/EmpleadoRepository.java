package com.vacaciones.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.modelos.Empleado;

/**
 * Repositorio para la comunicación con la base de datos de la entidad Empleado
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado,Integer> {
	Empleado findByEmail(String email);
}
