package com.vacaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.repositorios.EmpleadoRepository;

@Service
public class EmpleadoServicio {
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public Empleado anadirEmpleado(Empleado e) {
		return empleadoRepository.save(e);
	}
	
	public void borrarEmpleado(String email) {
		empleadoRepository.deleteById(email);
	}
	
	public void borrarEmpleado(Empleado e) {
		empleadoRepository.delete(e);
	}
	
	public Empleado editarEmpleado(Empleado e) {
		return empleadoRepository.save(e);
	}
	
	public Empleado buscarPorEmail(String email) {
		return empleadoRepository.findById(email).orElse(null);
	}
	public List<Empleado> listarEmpleados(){
		return empleadoRepository.findAll();
	}
	
	
}
