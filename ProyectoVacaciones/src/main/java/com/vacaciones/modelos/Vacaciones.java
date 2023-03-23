package com.vacaciones.modelos;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="vacation")
@EntityListeners(AuditingEntityListener.class)
public class Vacaciones {

	@Id
	@GeneratedValue
	private int id;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_solicitud")
	private Date fechaSolicitud;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_inicio")
	private Date fechaInicio;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_fin")
	private Date fechaFin;
	
	@ManyToOne
	@JoinColumn(name="id_empleado")
	private Empleado empleado;
	
	
	@Column(name="estado")
	private String estado;
	public Vacaciones() {
		
	}
	
	public Vacaciones(Date fechaSolicitud, Date fechaInicio, Date fechaFin, Empleado empleado, String estado) {
		super();
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
		this.estado = estado;
	}

	public Vacaciones(int id, Date fechaSolicitud, Date fechaInicio, Date fechaFin, Empleado empleado, String estado) {
		super();
		this.id = id;
		this.fechaSolicitud = fechaSolicitud;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.empleado = empleado;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
