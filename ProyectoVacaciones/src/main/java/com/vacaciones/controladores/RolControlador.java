package com.vacaciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vacaciones.modelos.Rol;
import com.vacaciones.servicios.RolServicio;

/**
 * Controlador para la entidad Rol del sistema de vacaciones
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@RestController
@RequestMapping("/roles")
public class RolControlador {
	@Autowired
	RolServicio rolService;
	
	/**
	 * Método para obtener los roles de la BD
	 * @return El listado de roles junto la respuesta OK 200
	 */
	@GetMapping("/listar")
	public ResponseEntity<List<Rol>> obtenerRoles(){
		List<Rol> roles= rolService.listarRoles();
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	/**
	 * Método para anadir un rol a la base de datos (actualmente no usado)
	 * @param rol
	 * @return El nuevo rol anadido y la respuesta CREATED 201
	 */
	@PostMapping("/anadir")
	public ResponseEntity<Rol> anadirRol(@RequestBody Rol rol){
		Rol nuevo = rolService.anadirRol(rol);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
		
	}
	
}
