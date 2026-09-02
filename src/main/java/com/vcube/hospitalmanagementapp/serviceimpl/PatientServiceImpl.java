package com.vcube.hospitalmanagementapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.exception.ResourceNotFoundException;
import com.vcube.hospitalmanagementapp.model.Patient;
import com.vcube.hospitalmanagementapp.repo.PatientRepo;
import com.vcube.hospitalmanagementapp.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepo patientRepo;

	// Save Patient
	@Override
	public Patient savePatient(Patient patient) {
		return patientRepo.save(patient);
	}

	// Get All Patients
	@Override
	public List<Patient> getPatients() {
		return patientRepo.findAll();
	}

	// Get Patient By ID
	@Override
	public Patient getPatientsByid(Integer patientId) {

		return patientRepo.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));
	}

	// Update Patient
	@Override
	public Patient updatePatientById(Patient patient, Integer patientId) {

		Patient existingPatient = patientRepo.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

		existingPatient.setPatientName(patient.getPatientName());
		existingPatient.setPhone(patient.getPhone());

		return patientRepo.save(existingPatient);
	}

	// Delete Patient
	@Override
	public void deletePatientById(Integer patientId) {

		Patient existingPatient = patientRepo.findById(patientId)
				.orElseThrow(() -> new ResourceNotFoundException("Patient not found with ID: " + patientId));

		patientRepo.delete(existingPatient);
	}
}