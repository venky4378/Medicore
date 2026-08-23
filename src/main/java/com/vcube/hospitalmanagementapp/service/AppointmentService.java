package com.vcube.hospitalmanagementapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.model.Appointment;

public interface AppointmentService {
	
	public abstract Appointment saveAppointment(Appointment appointment);

	public abstract List<Appointment> getAppointment();
	
	
	public abstract Appointment getAppointmentById(Integer id);
	
	public abstract Appointment updateAppointment(Appointment appointment,Integer appointmentId);
	
	public abstract void deleteAppointment(Integer appointmentId);
}
