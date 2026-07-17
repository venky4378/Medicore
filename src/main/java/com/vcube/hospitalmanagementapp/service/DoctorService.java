package com.vcube.hospitalmanagementapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.model.Doctor;

public interface DoctorService {

	public abstract Doctor saveDoctor(Doctor doctor);

	public abstract List<Doctor> getAllDoctorsList();

	public abstract List<Doctor> getHospitalHospitalId(Integer hospitalId);

	public abstract List<Doctor> findBySpecialization(String specialization);

	public abstract List<Doctor> findByDoctorNameContaining(String doctorName);
	
	public abstract void  deleteDoctorById(Integer doctorId);
	
	public abstract Doctor updateDoctor(Doctor doctor);
}
