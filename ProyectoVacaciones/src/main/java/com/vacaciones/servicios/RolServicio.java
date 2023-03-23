package com.vacaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Rol;
import com.vacaciones.repositorios.RolRepository;

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
