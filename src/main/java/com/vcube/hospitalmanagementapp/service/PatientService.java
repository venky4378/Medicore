package com.vcube.hospitalmanagementapp.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.model.Patient;

@Service
public interface PatientService {
	public abstract Patient savePatient(Patient patient);
	public abstract List<Patient> getPatients();
	public abstract Patient getPatientsByid(Integer patientId);
	public abstract <List>Patient getPatientByDoctorId(Integer doctorId);
	public abstract <List>Patient getPatientByHospitalId(Integer hospitalId);
	
	public abstract void deletePatientById(Integer patientId);
	Patient updatePatientById(Patient patient, Integer patientId);

}
