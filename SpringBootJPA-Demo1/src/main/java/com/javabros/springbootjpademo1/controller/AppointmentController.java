package com.javabros.springbootjpademo1.controller;

import com.javabros.springbootjpademo1.model.Appointment;
import com.javabros.springbootjpademo1.service.AppointmentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    @Autowired
    AppointmentService appointmentService;

    @PostMapping("/add")
    ResponseEntity <Appointment> addAppointment(@RequestBody Appointment appointment){
      return new ResponseEntity<>(appointmentService.saveAppointment(appointment), HttpStatus.CREATED)  ;
    }
    
    @GetMapping("/get")
	public ResponseEntity<List<Appointment>> getdetails() {
		return new ResponseEntity<>(appointmentService.getAllAppointments(),HttpStatus.OK);
	}
    
//    @GetMapping("get/{userId}")
//    public ResponseEntity<List<Appointment>> getMyAppointment(@PathVariable String userId){
//        return new ResponseEntity<>(appointmentService.getMyAppointments(userId),HttpStatus.OK);
//      }
//    
    @GetMapping("get/{appointmentId}")
	public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long appointmentId){
		return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
	}
    
    @PutMapping("put/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long appointmentId, @RequestBody Appointment appointment){
    	return new ResponseEntity<>(appointmentService.updatedetails(appointmentId, appointment), HttpStatus.OK);
    }
    
//    @PutMapping("put/{userId}")
//    public ResponseEntity<Appointment> updateMyAppointment(@PathVariable String userId, @RequestBody Appointment appointment){
//    	return new ResponseEntity<>(appointmentService.updateMydetails(userId, appointment), HttpStatus.OK);
//    }
    
   @DeleteMapping("/delete/{appointmentId}")
	public ResponseEntity<String> deleteiddetails(@PathVariable Long appointmentId) {		
		return new ResponseEntity<String>(appointmentService.deletedetails(appointmentId),HttpStatus.OK);
	}
}
