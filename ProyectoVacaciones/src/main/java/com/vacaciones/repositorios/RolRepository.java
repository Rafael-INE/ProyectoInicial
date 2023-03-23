package com.vacaciones.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vacaciones.modelos.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol,Integer> {
	
}
