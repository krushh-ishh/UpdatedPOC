package com.javabros.springbootjpademo1.service;

import com.javabros.springbootjpademo1.model.Appointment;
import com.javabros.springbootjpademo1.repository.AppointmentRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepo appointmentRepo;

	public Appointment saveAppointment(Appointment appointment){
		return appointmentRepo.save(appointment);
	}

	public List<Appointment> getAllAppointments() {
		return appointmentRepo.findAll();
	}
	
	public Appointment getAppointmentById(Long id) {
	Optional<Appointment> appointment2 = appointmentRepo.findById(id);		
		if(appointment2.isPresent()) {
			return appointmentRepo.getById(id);
		}
		else return null;
	}
	
	public List<Appointment> getMyAppointments(String userId) {
		List<Appointment> list = appointmentRepo.findAll().stream().filter(i->i.getUserId()==userId).collect(Collectors.toList());			
			if(list.size()> 0) {
				return list;
			}
			else return null;
		}
	public Appointment updatedetails(Long id, Appointment appointment) {
		Optional<Appointment> appointment2 = appointmentRepo.findById(id);
		
		if(appointment2.isPresent()) {
			appointment2.get().setAppointmentTime(appointment.getAppointmentTime());
			appointment2.get().setAppointmentDay(appointment.getAppointmentDay());			
			return appointmentRepo.save(appointment2.get());
		}
		else {
			return null;
		}
	}
	
	public Appointment updateMydetails(String userId, Appointment appointment) {
		Appointment appointment2 = appointmentRepo.findAll().stream().filter(i->i.getUserId()==userId).findFirst().get();	
		
		if(appointment2!=null) {
			appointment2.setAppointmentTime(appointment.getAppointmentTime());
			appointment2.setAppointmentDay(appointment.getAppointmentDay());			
			return appointmentRepo.save(appointment2);
		}
		else {
			return null;
		}
	}

	public String deletedetails(long id) {
		Appointment appointment = appointmentRepo.findAll().stream().filter(i->i.getAppointmentId()==id).findFirst().get();		
		if(appointment!=null) {
			appointmentRepo.deleteById(id);
			return "Deleted Successfully";
		}
		else {
			return "Element not found";
		}
	}


}
