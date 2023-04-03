package com.javabros.springbootjpademo1.model;

import lombok.Data;

import java.util.Objects;

import javax.persistence.*;

@Entity
public class Appointment {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "appointment_id", nullable = false)
    private Long appointmentId;
 
	@Column
	private String userId;
	
	@Column
	private String appointmentDay;
	
	@Column
	private String appointmentTime;
	
	@Column
	private String appointmentWith;

	public Long getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAppointmentDay() {
		return appointmentDay;
	}

	public void setAppointmentDay(String appointmentDay) {
		this.appointmentDay = appointmentDay;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	public String getAppointmentWith() {
		return appointmentWith;
	}

	public void setAppointmentWith(String appointmentWith) {
		this.appointmentWith = appointmentWith;
	}

	@Override
	public int hashCode() {
		return Objects.hash(appointmentDay, appointmentId, appointmentTime, appointmentWith, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		return Objects.equals(appointmentDay, other.appointmentDay)
				&& Objects.equals(appointmentId, other.appointmentId)
				&& Objects.equals(appointmentTime, other.appointmentTime)
				&& Objects.equals(appointmentWith, other.appointmentWith) && Objects.equals(userId, other.userId);
	}

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Appointment(Long appointmentId, String userId, String appointmentDay, String appointmentTime,
			String appointmentWith) {
		super();
		this.appointmentId = appointmentId;
		this.userId = userId;
		this.appointmentDay = appointmentDay;
		this.appointmentTime = appointmentTime;
		this.appointmentWith = appointmentWith;
	}
	
	

}
