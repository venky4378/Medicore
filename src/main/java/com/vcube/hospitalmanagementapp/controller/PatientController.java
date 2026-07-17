package com.vcube.hospitalmanagementapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.hospitalmanagementapp.model.Patient;
import com.vcube.hospitalmanagementapp.service.PatientService;

import org.springframework.web.bind.annotation.RequestBody;
@RestController
@RequestMapping("/patient/api/v1")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("/savepatient/api/v1")
	public Patient savePatient(@RequestBody Patient patient){
		return patientService.savePatient(patient);
	}

}
