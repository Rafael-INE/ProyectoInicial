package com.vacaciones.modelos;

public class Empleado {
	private String email;
	private String pwd;
	private String first_name;
	private String last_name;
	private int roles;
	
	public Empleado(String email, String pwd, String first_name, String last_name, int roles) {
		this.email = email;
		this.pwd = pwd;
		this.first_name = first_name;
		this.last_name = last_name;
		this.roles = roles;
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
	public int getRoles() {
		return roles;
	}
	public void setRoles(int roles) {
		this.roles = roles;
	}
	
	
}
