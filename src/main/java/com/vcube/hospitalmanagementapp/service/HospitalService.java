package com.vcube.hospitalmanagementapp.service;

import java.util.List;

import com.vcube.hospitalmanagementapp.model.Hospital;


public interface HospitalService {
	
	public abstract Hospital saveHospital(Hospital hospital);
	
	public abstract List<Hospital> getAllHospital();
	
	public abstract Hospital getHospitalById(Integer hospitalId);
	
	public abstract List<Hospital> getHospitalListByLocation(String location);
	
	public abstract Hospital getHospitalByName(String hospitalName);
	
	public abstract  Hospital updateHospitalById(Hospital hospital);
	
	public abstract void deleteHospitalBId(Integer hospitalId);
	
	
	
	
	
	
	
	
	
}
