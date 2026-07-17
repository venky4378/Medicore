package com.vcube.hospitalmanagementapp.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.model.Appointment;
import com.vcube.hospitalmanagementapp.repo.AppointmentRepo;
import com.vcube.hospitalmanagementapp.service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	
	@Autowired
	AppointmentRepo appointmentRepo;
	
	public Appointment saveAppointment(Appointment appointment) {
		return appointmentRepo.save(appointment);
	}
	
	

}
