package com.vcube.hospitalmanagementapp.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="appointment")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Appointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer appointmentId;
	private LocalDate appointmentDate;
	private String status;
	
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
//	@JsonBackReference
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
//	@JsonBackReference
	private Patient patient;
	
}
