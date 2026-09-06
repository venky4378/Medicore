package com.vcube.hospitalmanagementapp.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="patient")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    
    private String patientName;
    private Integer age;
    private String disease;
    private String phone;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"patient", "hibernateLazyInitializer", "handler"})
    private List<Appointment> appointments;
}