package com.vacaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.repositorios.EmpleadoRepository;

/**
 * Servicio que permite el acceso a la base de datos de empleados a través de los repositorios
 * @author rafael.alonso.ext
 *
 */
@Service
public class EmpleadoServicio {
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	public Empleado anadirEmpleado(Empleado e) {
		return empleadoRepository.save(e);
	}
	
	public void borrarEmpleado(int id) {
		empleadoRepository.deleteById(id);
	}
	
	public void borrarEmpleado(Empleado e) {
		empleadoRepository.delete(e);
	}
	
	public Empleado editarEmpleado(Empleado e) {
		return empleadoRepository.save(e);
	}
	
	public Empleado buscarPorId(int id) {
		return empleadoRepository.findById(id).orElse(null);
	}
	public List<Empleado> listarEmpleados(){
		return empleadoRepository.findAll();
	}
	
	public Empleado buscarPorEmail(String email) {
		return empleadoRepository.findByEmail(email);
	}
	
	
}
