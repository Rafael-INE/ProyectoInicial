package com.vacaciones;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.modelos.Rol;
import com.vacaciones.modelos.Vacaciones;
import com.vacaciones.servicios.EmpleadoServicio;
import com.vacaciones.servicios.RolServicio;
import com.vacaciones.servicios.VacacionesServicio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ProyectoVacacionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoVacacionesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner initData(EmpleadoServicio empleadoServicio, RolServicio rolServicio, VacacionesServicio vacacionesServicio) {
		return args -> {
			Rol rolAdmin = new Rol(1, "ADMIN");
			Rol rolJefe = new Rol(2, "JEFE");
			Rol rolEmpleado = new Rol(3, "EMPLEADO");
			
			rolAdmin = rolServicio.anadirRol(rolAdmin);
			rolJefe = rolServicio.anadirRol(rolJefe);
			rolEmpleado = rolServicio.anadirRol(rolEmpleado);
			
			Empleado empleado = new Empleado("alberto.ruiz@inetum.com", "1234", "Alberto", "Ruiz", rolEmpleado);
			empleado = empleadoServicio.anadirEmpleado(empleado);

			Empleado empleado2 = new Empleado("juan.lopez@inetum.com", "1234", "Juan", "Lopez", rolJefe);
			empleado2 = empleadoServicio.anadirEmpleado(empleado2);

			Vacaciones vacaciones = new Vacaciones(convertirFecha("2014-02-14"), convertirFecha("2014-02-14"), convertirFecha("2014-02-14"), empleado2, "pendiente");
			vacaciones = vacacionesServicio.anadirVacaciones(vacaciones);
			

		};
		
	}
	
	private Date convertirFecha(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
		} catch (ParseException e){
			return new Date();
		}
	}

}
