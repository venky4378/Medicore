package com.vcube.hospitalmanagementapp.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.exception.ResourceNotFoundException;
import com.vcube.hospitalmanagementapp.model.Patient;
import com.vcube.hospitalmanagementapp.repo.PatientRepo;
import com.vcube.hospitalmanagementapp.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	@Autowired
	PatientRepo patientRepo;
	 	
	public Patient savePatient(Patient patient){
		System.out.println(patient);
		System.out.println(patient.getPatientName());
		System.out.println(patient.getPhone());
		
		return patientRepo.save(patient);
	}

	@Override
	public List<Patient> getPatients() {
		return patientRepo.findAll();
	}

	@Override
	public Patient getPatientsByid(Integer patientId) {
		return patientRepo.findById(patientId).orElseThrow(()-> new ResourceNotFoundException("Petient not found by Id"));
	}

	@Override
	public Patient getPatientByDoctorId(Integer doctorId) {
		return patientRepo.findById(doctorId).orElseThrow(() -> new ResourceNotFoundException("Patient not Found By DoctorId"));
	}

	@Override
	public Patient getPatientByHospitalId(Integer hospitalId) {
		return patientRepo.findPatientByHospitalId(hospitalId);
	}

	@Override
	public Patient updatePatientById(Patient patient,Integer patientId) {
		Patient pat = patientRepo.findById(patientId).orElse(patient);
		pat.setPatientId(patient.getPatientId());
		pat.setPatientName(patient.getPatientName());
		return patientRepo.save(pat);
	}

	@Override
	public void deletePatientById(Integer patientId) {
		patientRepo.deleteById(patientId);
	}

	

}
