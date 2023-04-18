package com.vacaciones.seguridad;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * Clase para la generación y manejo de credenciales
 * Las credenciales tienen id, email asociado, password asociado y la lista de permisos que tiene dicho usuario
 * @author rafael.alonso.ext
 *
 */
public class AuthCredentials {
	private int id;
	private String email;
	private String password;
	private List<SimpleGrantedAuthority> authorities;
	public AuthCredentials() {
		
	}
	

	public AuthCredentials(int id, String email, String password, List<SimpleGrantedAuthority> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}
	public AuthCredentials(String email, String password, List<SimpleGrantedAuthority> authorities) {
		super();
		this.email = email;
		this.password = password;
		this.authorities = authorities;
	}



	public List<SimpleGrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(List<SimpleGrantedAuthority> authorities) {
		this.authorities = authorities;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
