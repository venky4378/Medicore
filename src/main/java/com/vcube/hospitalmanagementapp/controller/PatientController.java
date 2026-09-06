package com.vcube.hospitalmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.hospitalmanagementapp.model.Patient;
import com.vcube.hospitalmanagementapp.service.PatientService;

@RestController
@RequestMapping("/patient/api/v1")
@CrossOrigin(origins = "*") // FIX 1: Add CORS Support
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/savepatient")
	public Patient savePatient(@RequestBody Patient patient) {
		return patientService.savePatient(patient);
	}

	// FIX 2: Added /getAllPatients alias to match frontend service call
	@GetMapping({"/getPatients", "/getAllPatients"})
	public List<Patient> getPatients() {
		return patientService.getPatients();
	}

	@GetMapping("/getPatientById/{patientId}")
	public Patient getPatientById(@PathVariable Integer patientId) {
		return patientService.getPatientsByid(patientId);
	}

	@PutMapping("/updatepatient/{patientId}")
	public Patient updatePatient(@RequestBody Patient patient, @PathVariable Integer patientId) {
		return patientService.updatePatientById(patient, patientId);
	}

	@DeleteMapping("/deletepatient/{patientId}")
	public String deletePatient(@PathVariable Integer patientId) {
		patientService.deletePatientById(patientId);
		return "Patient deleted successfully";
	}
}