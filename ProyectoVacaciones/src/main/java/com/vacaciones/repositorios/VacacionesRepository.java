package com.vacaciones.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.modelos.Vacaciones;
/**
 * Repositorio para la comunicación con la base de datos de la entidad Vacaciones
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@Repository
public interface VacacionesRepository extends JpaRepository<Vacaciones,Integer>{
	
	List<Vacaciones> findByEmpleado(Empleado empleado);
}
