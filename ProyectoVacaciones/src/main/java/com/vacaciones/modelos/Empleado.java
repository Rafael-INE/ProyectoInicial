package com.vacaciones.modelos;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Entidad Empleado del sistema de vacaciones
 * Un empleado estará compuesto por:
 * 	Id
 * 	Nombre
 * 	Apellidos
 * 	Contrasena
 * 	Email
 * 	Rol
 * @author rafael.alonso.ext
 * @author mario.aparicio.ext
 */
@Entity
@Table(name="empleado")
public class Empleado implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="contrasena")
	private String contrasena;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellidos")
	private String apellidos;
	@ManyToOne
	@JoinColumn(name="rol_id")
	private Rol rol;
	
	public Empleado() {
		
	}

	
	public Empleado(String email, String contrasena, String nombre, String apellidos, Rol rol) {
		super();
		this.email = email;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rol = rol;
	}

	public Empleado(int id, String email, String contrasena, String nombre, String apellidos, Rol rol) {
		super();
		this.id = id;
		this.email = email;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
