package com.vacaciones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vacaciones.servicios.EmpleadoServicio;

@Controller
@RequestMapping("/users")
public class EmpleadoControlador {
	@Autowired
	EmpleadoServicio empleadoService;
	
	
}
