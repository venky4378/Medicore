import React, { useState, useEffect } from "react";
import axios from "axios";

const API_BASE_URL = "http://localhost:9900"; // Update port if different

export default function Appointments() {
  const [appointments, setAppointments] = useState([]);
  const [patients, setPatients] = useState([]);
  const [doctors, setDoctors] = useState([]);

  const [selectedPatient, setSelectedPatient] = useState("");
  const [selectedDoctor, setSelectedDoctor] = useState("");
  const [appointmentDate, setAppointmentDate] = useState("");

  useEffect(() => {
    fetchInitialData();
  }, []);

  const fetchInitialData = async () => {
    try {
      const [appRes, patRes, docRes] = await Promise.all([
        axios.get(`${API_BASE_URL}/appointment/api/v1/getAllAppointments`),
        axios.get(`${API_BASE_URL}/patient/api/v1/getAllPatients`),
        axios.get(`${API_BASE_URL}/doctor/api/v1/getAllDoctors`),
      ]);
      setAppointments(appRes.data || []);
      setPatients(patRes.data || []);
      setDoctors(docRes.data || []);
    } catch (error) {
      console.error("Error loading scheduling data:", error);
    }
  };

  const handleBookAppointment = async (e) => {
    e.preventDefault();
    if (!selectedPatient || !selectedDoctor || !appointmentDate) {
      alert("Please fill in all fields.");
      return;
    }

    const payload = {
      appointmentDate: appointmentDate,
      status: "Booked",
      patient: { patientId: parseInt(selectedPatient) },
      doctor: { doctorId: parseInt(selectedDoctor) },
    };

    try {
      await axios.post(`${API_BASE_URL}/appointment/api/v1/saveAppointment`, payload);
      setSelectedPatient("");
      setSelectedDoctor("");
      setAppointmentDate("");
      fetchInitialData();
    } catch (error) {
      console.error("Failed to save appointment:", error);
    }
  };

  const handleCancel = async (id) => {
    try {
      await axios.delete(`${API_BASE_URL}/appointment/api/v1/deleteAppointment/${id}`);
      fetchInitialData();
    } catch (error) {
      console.error("Failed to delete appointment:", error);
    }
  };

  return (
    <div className="container mt-4">
      <h3 className="text-center mb-4">Appointment Scheduling</h3>

      {/* Booking Form Card */}
      <div className="card mb-4 shadow-sm">
        <div className="card-header bg-primary text-white text-center fw-bold">
          Book New Appointment
        </div>
        <div className="card-body">
          <form onSubmit={handleBookAppointment} className="row g-3">
            <div className="col-md-4">
              <select
                className="form-select"
                value={selectedPatient}
                onChange={(e) => setSelectedPatient(e.target.value)}
              >
                <option value="">Select Patient</option>
                {patients.map((p) => (
                  <option key={p.patientId} value={p.patientId}>
                    {p.patientName}
                  </option>
                ))}
              </select>
            </div>

            <div className="col-md-4">
              <select
                className="form-select"
                value={selectedDoctor}
                onChange={(e) => setSelectedDoctor(e.target.value)}
              >
                <option value="">Select Doctor</option>
                {doctors.map((d) => (
                  <option key={d.doctorId} value={d.doctorId}>
                    {d.doctorName} ({d.specialization})
                  </option>
                ))}
              </select>
            </div>

            <div className="col-md-2">
              <input
                type="date"
                className="form-control"
                value={appointmentDate}
                onChange={(e) => setAppointmentDate(e.target.value)}
              />
            </div>

            <div className="col-md-2">
              <button type="submit" className="btn btn-success w-100">
                Book
              </button>
            </div>
          </form>
        </div>
      </div>

      {/* Data Table */}
      <div className="table-responsive">
        <table className="table table-bordered table-striped text-center align-middle">
          <thead className="table-dark">
            <tr>
              <th>ID</th>
              <th>Patient</th>
              <th>Doctor</th>
              <th>Date</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {appointments.length > 0 ? (
              appointments.map((a) => (
                <tr key={a.appointmentId}>
                  <td>{a.appointmentId}</td>
                  <td>{a.patient?.patientName || "N/A"}</td>
                  <td>{a.doctor?.doctorName || "N/A"}</td>
                  <td>{a.appointmentDate}</td>
                  <td>
                    <button
                      className="btn btn-danger btn-sm"
                      onClick={() => handleCancel(a.appointmentId)}
                    >
                      Cancel
                    </button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="5" className="text-muted">
                  No appointments scheduled.
                </td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
}