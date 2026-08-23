package com.vcube.hospitalmanagementapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.model.Appointment;
import com.vcube.hospitalmanagementapp.repo.AppointmentRepo;
import com.vcube.hospitalmanagementapp.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepo appointmentRepo;

	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}

	@Override
	public List<Appointment> getAppointment() {
		return appointmentRepo.findAll();
	}


	@Override
	public Appointment getAppointmentById(Integer id) {
		return appointmentRepo.findByAppointmentId(id);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment, Integer appointmentId) {
		Appointment app = appointmentRepo.findById(appointmentId).orElseThrow();

		appointment.setAppointmentDate(app.getAppointmentDate());
		appointment.setDoctor(app.getDoctor());
		appointment.setPatient(app.getPatient());
		appointment.setStatus(app.getStatus());

		return appointmentRepo.save(appointment);
	}

	@Override
	public void deleteAppointment(Integer appointmentId) {
		appointmentRepo.deleteById(appointmentId);

	}

}
