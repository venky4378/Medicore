package com.vcube.hospitalmanagementapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.exception.ResourceNotFoundException;
import com.vcube.hospitalmanagementapp.model.Appointment;
import com.vcube.hospitalmanagementapp.repo.AppointmentRepo;
import com.vcube.hospitalmanagementapp.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	private AppointmentRepo appointmentRepo;

	// Save Appointment
	@Override
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	// Get All Appointments
	@Override
	public List<Appointment> getAppointment() {
		return appointmentRepo.findAll();
	}

	// Get Appointment By ID
	@Override
	public Appointment getAppointmentById(Integer appointmentId) {

		return appointmentRepo.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));
	}

	// Update Appointment
	@Override
	public Appointment updateAppointment(Appointment appointment, Integer appointmentId) {

		Appointment existingAppointment = appointmentRepo.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

		existingAppointment.setAppointmentDate(appointment.getAppointmentDate());

		existingAppointment.setDoctor(appointment.getDoctor());

		existingAppointment.setPatient(appointment.getPatient());

		existingAppointment.setStatus(appointment.getStatus());

		return appointmentRepo.save(existingAppointment);
	}

	// Delete Appointment
	@Override
	public void deleteAppointment(Integer appointmentId) {

		Appointment existingAppointment = appointmentRepo.findById(appointmentId)
				.orElseThrow(() -> new ResourceNotFoundException("Appointment not found with ID: " + appointmentId));

		appointmentRepo.delete(existingAppointment);
	}
}