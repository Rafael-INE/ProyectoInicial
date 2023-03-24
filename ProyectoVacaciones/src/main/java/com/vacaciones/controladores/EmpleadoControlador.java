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

import com.vacaciones.modelos.Empleado;
import com.vacaciones.servicios.EmpleadoServicio;

@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
	@Autowired
	EmpleadoServicio empleadoService;
	
	@GetMapping(value={"","/","/listar"})
	public ResponseEntity<List<Empleado>> obtenerEmpleados(){
		List<Empleado> empleados= empleadoService.listarEmpleados();
		System.out.println();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable("id") int id){
		Empleado empleado = empleadoService.buscarPorId(id);
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	} 
	
	@PostMapping("/anadir")
	public ResponseEntity<Empleado> anadirEmpleado(@RequestBody Empleado empleado){
		Empleado nuevo = empleadoService.anadirEmpleado(empleado);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/modificar")
	public ResponseEntity<Empleado> modificarEmpleado(@RequestBody Empleado empleado){
		Empleado nuevo = empleadoService.editarEmpleado(empleado);
		return new ResponseEntity<>(nuevo, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarEmpleado(@PathVariable("id") int id){
		empleadoService.borrarEmpleado(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
}
