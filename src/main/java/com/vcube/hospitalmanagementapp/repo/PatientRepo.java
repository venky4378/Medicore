package com.vcube.hospitalmanagementapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.hospitalmanagementapp.model.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient,Integer> {
	
	List<Patient> findByPatientNameContaining(String patientName);
	Patient findByphone(String phone);
	Patient findPatientByHospitalId(Integer hospitalId);
}
