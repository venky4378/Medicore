package com.vcube.hospitalmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.hospitalmanagementapp.model.Doctor;
import com.vcube.hospitalmanagementapp.service.DoctorService;

@RestController
@RequestMapping("/doctor/api/v1")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;
	
	@PostMapping("/savedoctor")
	public Doctor saveDoctor(@RequestBody Doctor doctor){
		return doctorService.saveDoctor(doctor);
	}

	@GetMapping("/getAllDoctors")
	public List<Doctor> getAllDoctor(){
		return doctorService.getAllDoctorsList();	
	}
	
	@GetMapping("/getDoctorName/{doctorName}")
	public List<Doctor> getDoctorsContaining(@PathVariable String doctorName){
		return doctorService.findByDoctorNameContaining(doctorName);
	}
	
	@GetMapping("/getBySpecialization/{specialization}")
	public List<Doctor> getDoctorsBySpecialization(@PathVariable String specialization){
		return doctorService.findBySpecialization(specialization);
	}
	
	@GetMapping("/getDoctorById/{hospitalId}")
	public List<Doctor> getDoctorsByHospitalId(@PathVariable Integer hospitalId){
		return doctorService.getHospitalHospitalId(hospitalId);
	}
	
	
	
	
}
