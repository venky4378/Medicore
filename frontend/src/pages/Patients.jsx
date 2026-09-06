import { useEffect, useState } from "react";
import { getPatients, savePatient, deletePatient } from "../services/patientService";

function Patients() {
    const [patients, setPatients] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");

    // Form state
    const [patientName, setPatientName] = useState("");
    const [age, setAge] = useState("");
    const [disease, setDisease] = useState("");
    const [submitting, setSubmitting] = useState(false);

    useEffect(() => {
        loadPatients();
    }, []);

    const loadPatients = async () => {
        try {
            const response = await getPatients();
            setPatients(response.data);
        } catch (err) {
            console.error(err);
            setError("Failed to load patients.");
        } finally {
            setLoading(false);
        }
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setSubmitting(true);
        try {
            const newPatient = { patientName, age: Number(age), disease };
            await savePatient(newPatient);
            setPatientName("");
            setAge("");
            setDisease("");
            loadPatients();
        } catch (err) {
            console.error(err);
            alert("Failed to save patient.");
        } finally {
            setSubmitting(false);
        }
    };

    const handleDelete = async (id) => {
        if (!window.confirm("Are you sure you want to delete this patient?")) return;
        try {
            await deletePatient(id);
            loadPatients();
        } catch (err) {
            console.error(err);
            alert("Failed to delete patient.");
        }
    };

    if (loading) return <div className="container mt-4"><h3>Loading patients...</h3></div>;
    if (error) return <div className="container mt-4 alert alert-danger"><h3>{error}</h3></div>;

    return (
        <div className="container mt-4">
            <h2 className="mb-4">Patient Management</h2>

            {/* Add Patient Form */}
            <div className="card mb-4 shadow-sm">
                <div className="card-header bg-primary text-white">
                    <h5 className="mb-0">Add New Patient</h5>
                </div>
                <div className="card-body">
                    <form onSubmit={handleSubmit} className="row g-3">
                        <div className="col-md-4">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Patient Name"
                                value={patientName}
                                onChange={(e) => setPatientName(e.target.value)}
                                required
                            />
                        </div>
                        <div className="col-md-3">
                            <input
                                type="number"
                                className="form-control"
                                placeholder="Age"
                                value={age}
                                onChange={(e) => setAge(e.target.value)}
                                required
                            />
                        </div>
                        <div className="col-md-3">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Disease / Condition"
                                value={disease}
                                onChange={(e) => setDisease(e.target.value)}
                                required
                            />
                        </div>
                        <div className="col-md-2">
                            <button type="submit" className="btn btn-success w-100" disabled={submitting}>
                                {submitting ? "Saving..." : "Add Patient"}
                            </button>
                        </div>
                    </form>
                </div>
            </div>

            {/* Patients Table */}
            <table className="table table-bordered table-hover">
                <thead className="table-dark">
                    <tr>
                        <th>ID</th>
                        <th>Patient Name</th>
                        <th>Age</th>
                        <th>Disease</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {patients.length > 0 ? (
                        patients.map((patient) => (
                            <tr key={patient.patientId}>
                                <td>{patient.patientId}</td>
                                <td>{patient.patientName}</td>
                                <td>{patient.age}</td>
                                <td>{patient.disease}</td>
                                <td>
                                    <button
                                        className="btn btn-danger btn-sm"
                                        onClick={() => handleDelete(patient.patientId)}
                                    >
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="5" className="text-center">No patients found.</td>
                        </tr>
                    )} 
                </tbody>
            </table>
        </div>
    );
}

export default Patients;