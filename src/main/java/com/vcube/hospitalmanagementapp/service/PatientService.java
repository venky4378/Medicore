package com.vcube.hospitalmanagementapp.service;

import java.util.List;

import com.vcube.hospitalmanagementapp.model.Patient;

public interface PatientService {

	Patient savePatient(Patient patient);

	List<Patient> getPatients();

	Patient getPatientsByid(Integer patientId);

	Patient updatePatientById(Patient patient, Integer patientId);

	void deletePatientById(Integer patientId);
}