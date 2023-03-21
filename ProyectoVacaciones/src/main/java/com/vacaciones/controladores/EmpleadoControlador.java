package com.vacaciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.servicios.EmpleadoServicio;

@RestController
@RequestMapping("/users")
public class EmpleadoControlador {
	@Autowired
	EmpleadoServicio empleadoService;
	
	@GetMapping
	public ResponseEntity<List<Empleado>> obtenerEmpleados(){
		List<Empleado> empleados= empleadoService.listarEmpleados();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<List<Empleado>> obtenerEmpleadoPorEmail(@PathVariable("id") int id){
		//List<Empleado> empleados= empleadoService.listar;
		return new ResponseEntity<>(null, HttpStatus.OK);
	} 
	
	
	
}
