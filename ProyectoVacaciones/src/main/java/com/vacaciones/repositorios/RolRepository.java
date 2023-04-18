package com.vacaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.modelos.Rol;
/**
 * Repositorio para la comunicación con la base de datos de la entidad Rol
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
	
}
