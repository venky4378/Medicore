import api from "./api";

export const savePatient = (patientData) => 
  api.post("/patient/api/v1/savepatient", patientData);

export const getPatients = () => 
  api.get("/patient/api/v1/getPatients");

export const getPatientById = (patientId) => 
  api.get(`/patient/api/v1/getPatientById/${patientId}`);

export const updatePatient = (patientId, patientData) => 
  api.put(`/patient/api/v1/updatepatient/${patientId}`, patientData);

export const deletePatient = (patientId) => 
  api.delete(`/patient/api/v1/deletepatient/${patientId}`);