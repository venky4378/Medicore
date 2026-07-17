package com.vcube.hospitalmanagementapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.hospitalmanagementapp.model.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
	
	public abstract List<Doctor> findByHospitalHospitalId(Integer hospitalId);
	public abstract List<Doctor> findBySpecialization(String specialization);
	public abstract List<Doctor> findByDoctorNameContaining(String doctorName);

}
 