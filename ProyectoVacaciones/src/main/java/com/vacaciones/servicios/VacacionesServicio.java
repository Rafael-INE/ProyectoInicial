package com.vacaciones.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.modelos.Vacaciones;
import com.vacaciones.repositorios.VacacionesRepository;
/**
 * Servicio que permite el acceso a la base de datos de roles a través de los repositorios
 * @author rafael.alonso.ext
 *
 */
@Service
public class VacacionesServicio {
	@Autowired
	VacacionesRepository vacacionesRepository;
	
	public Vacaciones anadirVacaciones(Vacaciones v) {
		return vacacionesRepository.save(v);
	}
	
	public void borrarVacaciones(int id) {
		vacacionesRepository.deleteById(id);
	}
	
	public void borrarVacaciones(Vacaciones v) {
		vacacionesRepository.delete(v);
	}
	
	public Vacaciones editarVacaciones(Vacaciones v) {
		return vacacionesRepository.save(v);
	}
	
	public Vacaciones buscarPorId(int id) {
		return vacacionesRepository.findById(id).orElse(null);
	}
	public List<Vacaciones> listarVacaciones(){
		return vacacionesRepository.findAll();
	}
	
	public  List<Vacaciones> listarVacacionesPorEmpleado(Empleado empleado){
		return vacacionesRepository.findByEmpleado(empleado);
	}


}
