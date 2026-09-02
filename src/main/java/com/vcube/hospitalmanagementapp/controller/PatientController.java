package com.vcube.hospitalmanagementapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vcube.hospitalmanagementapp.model.Patient;
import com.vcube.hospitalmanagementapp.service.PatientService;

@RestController
@RequestMapping("/patient/api/v1")
public class PatientController {

    @Autowired
    private PatientService patientService;

    // Save Patient
    @PostMapping("/savepatient")
    public Patient savePatient(@RequestBody Patient patient) {
        return patientService.savePatient(patient);
    }

    // Get All Patients
    @GetMapping("/getPatients")
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    // Get Patient By ID
    @GetMapping("/getPatientById/{patientId}")
    public Patient getPatientById(@PathVariable Integer patientId) {
        return patientService.getPatientsByid(patientId);
    }

    // Update Patient
    @PutMapping("/updatepatient/{patientId}")
    public Patient updatePatient(
            @RequestBody Patient patient,
            @PathVariable Integer patientId) {

        return patientService.updatePatientById(patient, patientId);
    }

    // Delete Patient
    @DeleteMapping("/deletepatient/{patientId}")
    public String deletePatient(@PathVariable Integer patientId) {

        patientService.deletePatientById(patientId);

        return "Patient deleted successfully";
    }
}