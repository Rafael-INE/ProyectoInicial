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
import com.vacaciones.servicios.VacacionesServicio;

@RestController
@RequestMapping("/vacaciones")
public class VacacionesControlador {
	@Autowired
	VacacionesServicio vacacionesService;
	
	@GetMapping(value={"","/","/listar"})
	public ResponseEntity<List<Vacaciones>> obtenerVacaciones(){
		List<Vacaciones> vacaciones= vacacionesService.listarVacaciones();
		return new ResponseEntity<>(vacaciones, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Vacaciones> obtenerVacacionesPorId(@PathVariable("id") int id){
		Vacaciones vacaciones =vacacionesService.buscarPorId(id);
		return new ResponseEntity<>(vacaciones, HttpStatus.OK);
	} 
	
	@PostMapping("/anadir")
	public ResponseEntity<Vacaciones> anadirVacaciones(@RequestBody Vacaciones vacaciones){
		Vacaciones nuevasVacaciones = vacacionesService.anadirVacaciones(vacaciones);
		return new ResponseEntity<>(nuevasVacaciones, HttpStatus.CREATED);
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Vacaciones> modificarVacaciones(@RequestBody Vacaciones vacaciones){
		Vacaciones modificarVacaciones = vacacionesService.editarVacaciones(vacaciones);
		return new ResponseEntity<>(modificarVacaciones, HttpStatus.OK);
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarVacaciones(@PathVariable("id") int id){
		vacacionesService.borrarVacaciones(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
