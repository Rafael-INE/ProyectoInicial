package com.vacaciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.vacaciones.modelos.Empleado;
import com.vacaciones.modelos.Rol;
import com.vacaciones.modelos.Vacaciones;
import com.vacaciones.servicios.EmpleadoServicio;
import com.vacaciones.servicios.RolServicio;
import com.vacaciones.servicios.VacacionesServicio;

/**
 * Clase starter del sistema de vacaciones en el backend
 * Pobla una base de datos con uos datos iniciales
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@SpringBootApplication
public class ProyectoVacacionesApplication {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("1234"));
		SpringApplication.run(ProyectoVacacionesApplication.class, args);
	}
	
//	@Bean
//	public CorsFilter corsFilter() {
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
//				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
//				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//		return new CorsFilter(urlBasedCorsConfigurationSource);
//	}
//	
	
	/**
	 * Método para poblar la base de datos 
	 * @param empleadoServicio Servicio para introducir empleados
	 * @param rolServicio Servicio para introducir roles
	 * @param vacacionesServicio Servicio para introducir vacaciones
	 * @return
	 */
	@Bean
	public CommandLineRunner initData(EmpleadoServicio empleadoServicio, RolServicio rolServicio, VacacionesServicio vacacionesServicio) {
		return args -> {
			Rol rolAdmin = new Rol(1, "ADMIN");
			Rol rolJefe = new Rol(2, "JEFE");
			Rol rolEmpleado = new Rol(3, "EMPLEADO");
			
			rolAdmin = rolServicio.anadirRol(rolAdmin);
			rolJefe = rolServicio.anadirRol(rolJefe);
			rolEmpleado = rolServicio.anadirRol(rolEmpleado);
			
			Empleado empleado = new Empleado("alberto.ruiz@inetum.com", "$2a$10$/k4lFE/TbMyNqwUw7OQB8e5j8pAR8gflaQRdcbnAoVXh.ukBJdofe", "Alberto", "Ruiz", rolAdmin);
			empleado = empleadoServicio.anadirEmpleado(empleado);

			Empleado empleado2 = new Empleado("juan.lopez@inetum.com", "$2a$10$/k4lFE/TbMyNqwUw7OQB8e5j8pAR8gflaQRdcbnAoVXh.ukBJdofe", "Juan", "Lopez", rolJefe);
			empleado2 = empleadoServicio.anadirEmpleado(empleado2);
			
			Empleado empleado3 = new Empleado("manuel.ruiz@inetum.com", "$2a$10$/k4lFE/TbMyNqwUw7OQB8e5j8pAR8gflaQRdcbnAoVXh.ukBJdofe", "Manuel", "Ruiz", rolEmpleado);
			empleado3 = empleadoServicio.anadirEmpleado(empleado3);
			
			Empleado empleado4 = new Empleado("alfonso.ruiz@inetum.com", "$2a$10$/k4lFE/TbMyNqwUw7OQB8e5j8pAR8gflaQRdcbnAoVXh.ukBJdofe", "Alfonso", "Ruiz", rolEmpleado);
			empleado4 = empleadoServicio.anadirEmpleado(empleado4);

			Vacaciones vacaciones = new Vacaciones(convertirFecha("2014-02-14"), convertirFecha("2014-02-14"), convertirFecha("2014-02-14"), empleado2, "Aceptada");
			vacaciones = vacacionesServicio.anadirVacaciones(vacaciones);
			
			Vacaciones vacaciones2 = new Vacaciones(convertirFecha("2017-02-14"), convertirFecha("2017-02-14"), convertirFecha("2018-02-14"), empleado2, "Pendiente");
			vacaciones = vacacionesServicio.anadirVacaciones(vacaciones2);
			
			Vacaciones vacaciones3 = new Vacaciones(convertirFecha("2017-02-14"), convertirFecha("2018-02-14"), convertirFecha("2018-02-14"), empleado, "Denegada");
			vacaciones = vacacionesServicio.anadirVacaciones(vacaciones3);
			
			Vacaciones vacaciones4 = new Vacaciones(convertirFecha("2017-02-14"), convertirFecha("2018-02-14"), convertirFecha("2018-02-14"), empleado4, "Pendiente");
			vacaciones = vacacionesServicio.anadirVacaciones(vacaciones4);
			

		};
		
	}

	/**
	 * Este método es auxiliar para la conversión de fechas para la BD
	 * @param date Fecha de entrada 
	 * @return La fecha convertida
	 */
	private Date convertirFecha(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
			
		} catch (ParseException e){
			return new Date();
		}
	}

}
