package com.vcube.hospitalmanagementapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.exception.ResourceNotFoundException;
import com.vcube.hospitalmanagementapp.model.Hospital;
import com.vcube.hospitalmanagementapp.repo.HospitalRepoInterface;
import com.vcube.hospitalmanagementapp.service.HospitalService;

@Service
public class HospitalServiceImpl implements HospitalService {

	@Autowired
	HospitalRepoInterface hospitalRepo;

	@Override
	public Hospital saveHospital(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	@Override
	public List<Hospital> getHospitalListByLocation(String location) {
		return hospitalRepo.findByLocation(location);
	}

	@Override
	public Hospital getHospitalByName(String hospitalName) {
		return hospitalRepo.findByHospitalNameContaining(hospitalName);
	}

	@Override
	public Hospital getHospitalById(Integer hospitalId) {
		return hospitalRepo.findById(hospitalId).orElseThrow(() -> new ResourceNotFoundException("Hospital Not Found with ID :"+hospitalId));
	}

	@Override
	public List<Hospital> getAllHospital() {
		return hospitalRepo.findAll();
	}

	@Override
	public Hospital updateHospitalById(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	@Override
	public void deleteHospitalBId(Integer hospitalId) {
		hospitalRepo.deleteById(hospitalId);
	}

}
