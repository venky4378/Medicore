import api from "./api";

// Core save method
export const saveAppointment = (appointmentData) => 
  api.post("/appointment/api/v1/saveappointment", appointmentData);

export const createAppointment = (appointmentData) => 
  api.post("/appointment/api/v1/saveappointment", appointmentData);

export const getAppointmentById = (appointmentId) => 
  api.get(`/appointment/api/v1/getappointment/${appointmentId}`);

export const getAllAppointments = () => 
  api.get("/appointment/api/v1/getappointments");

export const updateAppointment = (appointmentId, appointmentData) => 
  api.patch(`/appointment/api/v1/updateappointment/${appointmentId}`, appointmentData);

export const deleteAppointment = (appointmentId) => 
  api.delete(`/appointment/api/v1/deleteappointment/${appointmentId}`);

export const cancelAppointment = (appointmentId) => 
  api.delete(`/appointment/api/v1/deleteappointment/${appointmentId}`);