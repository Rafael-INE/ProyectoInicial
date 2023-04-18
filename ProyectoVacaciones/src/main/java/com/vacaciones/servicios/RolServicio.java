package com.vacaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Rol;
import com.vacaciones.repositorios.RolRepository;

/**
 * Servicio que permite el acceso a la base de datos de roles a través de los repositorios
 * @author rafael.alonso.ext
 *
 */
@Service
public class RolServicio {
	@Autowired
	RolRepository rolRepository;
	
	public List<Rol> listarRoles(){
		return rolRepository.findAll();
	}
	
	public Rol anadirRol(Rol r) {
		return rolRepository.save(r);
	} 
	
}
