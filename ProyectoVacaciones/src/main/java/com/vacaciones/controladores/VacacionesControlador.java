package com.vacaciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.vacaciones.modelos.Vacaciones;
import com.vacaciones.servicios.EmpleadoServicio;
import com.vacaciones.servicios.VacacionesServicio;

/**
 * Controlador para la entidad Vacaciones del sistema de vacaciones
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@RestController
@RequestMapping("/vacaciones")
public class VacacionesControlador {
	@Autowired
	VacacionesServicio vacacionesService;
	@Autowired
	EmpleadoServicio empleadoService;
	/**
	 * Método que lista las vacaciones de la BD
	 * @return La lista de vacaciones junto con el estado OK 200
	 */
	@GetMapping(value={"","/","/listar"})
	public ResponseEntity<List<Vacaciones>> obtenerVacaciones(){
		List<Vacaciones> vacaciones= vacacionesService.listarVacaciones();
		return new ResponseEntity<>(vacaciones, HttpStatus.OK);
	}
	
	/**
	 * Método para obtener unas vacaciones según su id
	 * @param id Identificador único de vacacion pasado en la URL
	 * @return Vacaciones asociadas a dicho id, junto con OK 200
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Vacaciones> obtenerVacacionesPorId(@PathVariable("id") int id){
		Vacaciones vacaciones =vacacionesService.buscarPorId(id);
		return new ResponseEntity<>(vacaciones, HttpStatus.OK);
	} 
	
	/**
	 * Método para anadir vacaciones a la base de datos
	 * @param vacaciones Vacaciones para anadir a la BD
	 * @return Las vacaciones anadidas junto con la respuesta CREATED 201
	 */
	@PostMapping("/anadir")
	public ResponseEntity<Vacaciones> anadirVacaciones(@RequestBody Vacaciones vacaciones){
		Vacaciones nuevasVacaciones = vacacionesService.anadirVacaciones(vacaciones);
		return new ResponseEntity<>(nuevasVacaciones, HttpStatus.CREATED);
	}
	
	/**
	 * Método para modificar unas vacaciones
	 * @param vacaciones Vacaciones a modificar
	 * @return Las vacaciones editadas junto con la respuesta OK 200
	 */
	@PutMapping("/modificar")
	public ResponseEntity<Vacaciones> modificarVacaciones(@RequestBody Vacaciones vacaciones){
		Vacaciones modificarVacaciones = vacacionesService.editarVacaciones(vacaciones);
		return new ResponseEntity<>(modificarVacaciones, HttpStatus.OK);
	}
	
	/**
	 * Método para borrar unas vacaciones
	 * @param id Identificador de vacaciones pasado en la URL
	 * @return Estado OK 200 y las vacaciones se han borrado
	 */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarVacaciones(@PathVariable("id") int id){
		vacacionesService.borrarVacaciones(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	/**
	 * Método que retorna las vacaciones de un empleado concreto, según su id
	 * @param idEmpleado Identificador único de empleado pasado en la URL
	 * @return La lista de vacaciones solicitadas por dicho empleado, junto con el estado OK 200
	 */
	@GetMapping("/listar/{id}")
	public ResponseEntity<List<Vacaciones>>obtenerVacacionesPorEmpleado(@PathVariable("id") int idEmpleado){
		
		List<Vacaciones> vacaciones = 
				vacacionesService.listarVacacionesPorEmpleado(empleadoService.buscarPorId(idEmpleado));
		return new ResponseEntity<>(vacaciones, HttpStatus.OK);
	}
}
