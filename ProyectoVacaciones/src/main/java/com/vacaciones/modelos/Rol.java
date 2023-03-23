package com.vacaciones.modelos;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="rol")
public class Rol implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	@Column(name="descripcion")
	private String descripcion;
	
	public Rol() {
		
	}
	public Rol(int id) {
		super();
		this.id = id;
	}
	
	public Rol(String descripcion) {
		super();
		this.descripcion = descripcion;
	}
	public Rol(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	//@OneToMany(mappedBy = "employee",cascade= CascadeType.ALL, orphanRemoval=true)
	//private Set<Empleado> empleados;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
}
