package com.vcube.hospitalmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.hospitalmanagementapp.model.Appointment;
import com.vcube.hospitalmanagementapp.service.AppointmentService;

import org.springframework.web.bind.annotation.RequestBody;
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

}
