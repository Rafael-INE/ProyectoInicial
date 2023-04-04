package com.vacaciones.seguridad;

import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class AuthCredentials {
	private String email;
	private String password;
	private List<SimpleGrantedAuthority> authorities;
	public AuthCredentials() {
		
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
