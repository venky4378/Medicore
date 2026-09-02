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
	private AppointmentService appointmentService;

	// Save Appointment
	@PostMapping("/saveappointment")
	public Appointment saveAppointment(@RequestBody Appointment appointment) {

		return appointmentService.saveAppointment(appointment);
	}

	// Get Appointment By ID
	@GetMapping("/getappointment/{appointmentId}")
	public Appointment getAppointment(@PathVariable Integer appointmentId) {

		return appointmentService.getAppointmentById(appointmentId);
	}

	// Get All Appointments
	@GetMapping("/getappointments")
	public List<Appointment> getAllAppointments() {

		return appointmentService.getAppointment();
	}

	// Update Appointment
	@PatchMapping("/updateappointment/{appointmentId}")
	public Appointment updateAppointment(@RequestBody Appointment appointment, @PathVariable Integer appointmentId) {

		return appointmentService.updateAppointment(appointment, appointmentId);
	}

	// Delete Appointment
	@DeleteMapping("/deleteappointment/{appointmentId}")
	public String deleteAppointment(@PathVariable Integer appointmentId) {

		appointmentService.deleteAppointment(appointmentId);

		return "Appointment deleted successfully";
	}
}