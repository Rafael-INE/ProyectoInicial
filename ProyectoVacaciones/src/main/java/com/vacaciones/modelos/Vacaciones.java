package com.vacaciones.modelos;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
	@Column(name="request_date")
	private Date requestDate;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_date")
	private Date startDate;
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="finish_date")
	private Date finishDate;
	
	@ManyToOne
	private Empleado empleado;
	
	
	@Column(name="state")
	private String state;
	
	public Vacaciones(Date requestDate, Date startDate, Date finishDate, String state) {
		this.requestDate = requestDate;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.state = state;
	}
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
