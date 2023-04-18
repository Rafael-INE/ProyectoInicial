package com.vacaciones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

/**
 * Controlador para la entidad Empleado del sistema de vacaciones
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@RestController
@RequestMapping("/empleados")
public class EmpleadoControlador {
	@Autowired
	EmpleadoServicio empleadoService;
	
	/**
	 * Método para obtener todos los empleados de la BD
	 * @return Lista de empleados junto con la respuesta OK
	 */
	@GetMapping("/listar")
	public ResponseEntity<List<Empleado>> obtenerEmpleados(){
		List<Empleado> empleados= empleadoService.listarEmpleados();
		return new ResponseEntity<>(empleados, HttpStatus.OK);
	}
	
	/**
	 * Método para obtener un empleado según su id
	 * @param id Identificador único de empleado pasado en la URL
	 * @return Empleado asociado a dicho id
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorId(@PathVariable("id") int id){
		Empleado empleado = empleadoService.buscarPorId(id);
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	} 
	
	/**
	 * Método para encontrar un empleado según su correo (username),
	 * sirve para obtener el empleado concreto tras el login
	 * @param email Email de empleado, pasado por ruta
	 * @return Empleado asociado a dicho correo
	 */
	@GetMapping("/find/{username}")
	public ResponseEntity<Empleado> obtenerEmpleadoPorEmail(@PathVariable("username") String email ){
		Empleado empleado = empleadoService.buscarPorEmail(email);
		return new ResponseEntity<>(empleado, HttpStatus.OK);
	} 
	
	/**
	 * Método para anadir un empleado a la base de datos,
	 * además codifica la contraseña en claro del frontend (en este caso codifica su nombre)
	 * cambiará en el futuro
	 * @param empleado Empleado para anadir a la base de datos
	 * @return El nuevo empleado, junto con el estado CREATED 201
	 */
	@PostMapping("/anadir")
	public ResponseEntity<Empleado> anadirEmpleado(@RequestBody Empleado empleado){
		// TODO: Generación de contrasena y envío al correo
		empleado.setContrasena(new BCryptPasswordEncoder().encode(empleado.getNombre()));
		Empleado nuevo = empleadoService.anadirEmpleado(empleado);
		return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
		
	}
	
	/**
	 * Método para modificar un empleado en la BD
	 * @param empleado Empleado modificado
	 * @return Los nuevos datos del empleado, con la respuesta OK 200
	 */
	@PutMapping("/modificar")
	public ResponseEntity<Empleado> modificarEmpleado(@RequestBody Empleado empleado){
		Empleado nuevo = empleadoService.editarEmpleado(empleado);
		return new ResponseEntity<>(nuevo, HttpStatus.OK);
		
	}
	
	/**
	 * Método para borrar un empleado de la BD
	 * @param id Identificador del empleado a borrar, pasado por ruta
	 * @return Un estado OK 200, indicando que se ha borrado
	 */
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> borrarEmpleado(@PathVariable("id") int id){
		empleadoService.borrarEmpleado(id);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	/**
	 * Método para editar el perfil de un usuario, a diferencia de modificarEmpleado
	 * este método si que codifica un contraseña en claro generada por el usuario en el frontend
	 * @param empleado Empleado modificado
	 * @return Los nuevos ddatos del empleado, con respuesta OK 200
	 */
	@PutMapping("/editarPerfil")
	public ResponseEntity<Empleado> editarPerfil(@RequestBody Empleado empleado){
		empleado.setContrasena(new BCryptPasswordEncoder().encode(empleado.getContrasena()));
		Empleado nuevo = empleadoService.editarEmpleado(empleado);
		return new ResponseEntity<>(nuevo, HttpStatus.OK);
		
	}
	
}
