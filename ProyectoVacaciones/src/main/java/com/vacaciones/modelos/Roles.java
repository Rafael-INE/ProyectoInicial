package com.vacaciones.modelos;

public class Roles {
	private int role_id;
	private String description;
	
	public Roles(int role_id, String description) {
		this.role_id = role_id;
		this.description = description;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
