package com.vcube.hospitalmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.hospitalmanagementapp.model.Appointment;
import com.vcube.hospitalmanagementapp.service.AppointmentService;
@RestController
@RequestMapping("/appointment/api/v1")
public class AppointmentController {
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("/saveappointment/api/v1")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {	
		 System.out.println("Date : " + appointment.getAppointmentDate());
		    System.out.println("Status : " + appointment.getStatus());
		    System.out.println("Doctor : " + appointment.getDoctor());
		    System.out.println("Patient : " + appointment.getPatient());
		return appointmentService.saveAppointment(appointment);
	}
	   
	
	
	@GetMapping("/getappointment/{appointmentid}")
	public Appointment getAppointment(@PathVariable Integer appointmentId) {
		return appointmentService.getAppointmentById(appointmentId);
	}
	
	@GetMapping("/getappointments")
	public List<Appointment> getAllAppointments(){
		return appointmentService.getAppointment();
	}
	
	@DeleteMapping("/deleteappointment/{id}")
	public String deleteAppointment(@PathVariable Integer id) {
		appointmentService.deleteAppointment(id);
		return "delete successfully";
	}
	
	@PatchMapping("updateappointment/{id}")
	public Appointment updateAppointment(@RequestBody Appointment appointment, @PathVariable Integer id) {
		return appointmentService.updateAppointment(appointment,id);
	}  

}
