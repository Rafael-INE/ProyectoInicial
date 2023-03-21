package com.vacaciones.modelos;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="vacation")
@EntityListeners(AuditingEntityListener.class)
public class Vacaciones {

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
	
	private String emailRequester;
	
	@Column(name="state")
	private String state;
	
	public Vacaciones(Date requestDate, Date startDate, Date finishDate, String emailRequester, String state) {
		
		this.requestDate = requestDate;
		this.startDate = startDate;
		this.finishDate = finishDate;
		this.emailRequester = emailRequester;
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
	public String getEmailRequester() {
		return emailRequester;
	}
	public void setEmailRequester(String emailRequester) {
		this.emailRequester = emailRequester;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
