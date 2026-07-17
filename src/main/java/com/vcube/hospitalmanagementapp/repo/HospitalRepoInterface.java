package com.vcube.hospitalmanagementapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vcube.hospitalmanagementapp.model.Hospital;

@Repository
public interface HospitalRepoInterface extends JpaRepository<Hospital,Integer>{

	List<Hospital> findByLocation(String location);
	
	Hospital findByHospitalNameContaining(String hospitalName);
	

}
