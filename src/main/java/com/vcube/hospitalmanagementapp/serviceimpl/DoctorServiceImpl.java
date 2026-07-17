package com.vcube.hospitalmanagementapp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcube.hospitalmanagementapp.model.Doctor;
import com.vcube.hospitalmanagementapp.repo.DoctorRepo;
import com.vcube.hospitalmanagementapp.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepo doctorRepo;

	@Override
	public Doctor saveDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public List<Doctor> getAllDoctorsList() {
		return doctorRepo.findAll();
	}

	@Override
	public List<Doctor> getHospitalHospitalId(Integer hospitalId) {
		return doctorRepo.findByHospitalHospitalId(hospitalId);
	}

	@Override
	public List<Doctor> findBySpecialization(String specialization) {
		return doctorRepo.findBySpecialization(specialization);
	}

	@Override
	public List<Doctor> findByDoctorNameContaining(String doctorName) {
		return doctorRepo.findByDoctorNameContaining(doctorName);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		return doctorRepo.save(doctor);
	}

	@Override
	public void deleteDoctorById(Integer doctorId) {
		doctorRepo.deleteById(doctorId);

	}
}
