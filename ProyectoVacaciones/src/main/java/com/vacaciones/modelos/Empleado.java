package com.vacaciones.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity

public class Empleado {
	@Id @GeneratedValue
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="password")
	private String pwd;
	@Column(name="first_name")
	private String first_name;
	@Column(name="last_name")
	private String last_name;
	@ManyToOne
	private Role role;
	
	
	public Empleado(String email, String pwd, String first_name, String last_name, Role role) {
		this.email = email;
		this.pwd = pwd;
		this.first_name = first_name;
		this.last_name = last_name;
		this.role = role;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
