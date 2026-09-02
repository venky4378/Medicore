package com.vcube.hospitalmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.hospitalmanagementapp.model.Hospital;
import com.vcube.hospitalmanagementapp.service.HospitalService;

@RestController
@RequestMapping("/hospital/api/v1")
public class HospitalController {
	
	@Autowired
	HospitalService hospitalService;
	
	@PostMapping("/savehospital"	)
	public Hospital saveHospitalInfo(@RequestBody Hospital hospital) {
		return hospitalService.saveHospital(hospital);
	}
	
	@GetMapping("/getAllHospitals")
	public List<Hospital> getHospital(){
		return hospitalService.getAllHospital();
	}
	
	@GetMapping("/getHospitalByName/{hospitalName}")
	public Hospital getHospitalByName(@PathVariable String hospitalName){
		return hospitalService.getHospitalByName(hospitalName);
	}
	
	@GetMapping("/getByHospitalById/{hospitalId}")
	public Hospital getHospitalById(@PathVariable Integer hospitalId) {
		return hospitalService.getHospitalById(hospitalId);
	}
	
	@GetMapping("/getHospitalByLocation/{location}")
	public List<Hospital> getHospitalByLocation(@PathVariable String location) {
		return hospitalService.getHospitalListByLocation(location);
	}
	
	@PutMapping("/updatehospital/{hospitalId}")
	public Hospital updateHospital(@RequestBody Hospital hospital,@PathVariable Integer hospitalId) {
		return hospitalService.updateHospitalById(hospital,hospitalId);
	}
}
