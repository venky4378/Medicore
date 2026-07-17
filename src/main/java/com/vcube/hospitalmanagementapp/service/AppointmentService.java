package com.vcube.hospitalmanagementapp.service;

import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.model.Appointment;

@Service
public interface AppointmentService {
	
	public abstract Appointment saveAppointment(Appointment appointment);

}
