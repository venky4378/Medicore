import api from "./api";

export const saveDoctor = (doctorData) => 
  api.post("/doctor/api/v1/savedoctor", doctorData);

export const getAllDoctors = () => 
  api.get("/doctor/api/v1/getAllDoctors");

export const getDoctorsByName = (doctorName) => 
  api.get(`/doctor/api/v1/getDoctorName/${doctorName}`);

export const getDoctorsBySpecialization = (specialization) => 
  api.get(`/doctor/api/v1/getBySpecialization/${specialization}`);

export const getDoctorsByHospitalId = (hospitalId) => 
  api.get(`/doctor/api/v1/getDoctorById/${hospitalId}`);

// Update Doctor mapping
export const updateDoctor = (doctorId, doctorData) => 
  api.put(`/doctor/api/v1/updatedoctor/${doctorId}`, doctorData);

// Delete Doctor mapping
export const deleteDoctor = (doctorId) => 
  api.delete(`/doctor/api/v1/deletedoctor/${doctorId}`);