package com.vacaciones.seguridad.usuarios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.repositorios.EmpleadoRepository;

@Service
public class CustomUserDetailsService{
	
	public CustomUserDetailsService(EmpleadoRepository empleadoRepository) {
		
	}
}
