import { useEffect, useState } from "react";
import { 
    getAllDoctors, 
    saveDoctor, 
    updateDoctor, 
    deleteDoctor, 
    getDoctorsBySpecialization, 
    getDoctorsByHospitalId 
} from "../services/doctorService";

function Doctors() {
    const [doctors, setDoctors] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [statusMessage, setStatusMessage] = useState({ type: "", msg: "" });

    // Form state
    const [doctorName, setDoctorName] = useState("");
    const [specialization, setSpecialization] = useState("");
    const [editingId, setEditingId] = useState(null);
    const [submitting, setSubmitting] = useState(false);

    // Search/Filter state
    const [searchSpec, setSearchSpec] = useState("");
    const [searchHospitalId, setSearchHospitalId] = useState("");

    useEffect(() => {
        loadDoctors();
    }, []);

    const loadDoctors = async () => {
        setLoading(true);
        try {
            const response = await getAllDoctors();
            setDoctors(Array.isArray(response.data) ? response.data : []);
            setError("");
        } catch (err) {
            console.error("Failed to load doctors:", err);
            setError("Failed to load doctors from backend.");
            setDoctors([]);
        } finally {
            setLoading(false);
        }
    };

    const handleFormSubmit = async (e) => {
        e.preventDefault();
        if (!doctorName.trim() || !specialization.trim()) return;

        setSubmitting(true);
        setStatusMessage({ type: "", msg: "" });

        try {
            const doctorData = { doctorName: doctorName.trim(), specialization: specialization.trim() };

            if (editingId) {
                await updateDoctor(editingId, doctorData);
                setStatusMessage({ type: "success", msg: "Doctor updated successfully!" });
            } else {
                await saveDoctor(doctorData);
                setStatusMessage({ type: "success", msg: "Doctor added successfully!" });
            }

            resetForm();
            // CLEAR SEARCH INPUTS SO NEWLY ADDED DOCTORS ARE NOT HIDDEN BY FILTERS
            setSearchSpec("");
            setSearchHospitalId("");
            
            await loadDoctors();
        } catch (err) {
            console.error("Operation failed:", err);
            setStatusMessage({ type: "danger", msg: "Failed to save doctor details." });
        } finally {
            setSubmitting(false);
        }
    };

    const handleEditClick = (doc) => {
        setEditingId(doc.doctorId);
        setDoctorName(doc.doctorName || "");
        setSpecialization(doc.specialization || "");
    };

    const handleDeleteClick = async (doctorId) => {
        if (!window.confirm(`Delete doctor record ID ${doctorId}?`)) return;

        try {
            await deleteDoctor(doctorId);
            setStatusMessage({ type: "warning", msg: "Doctor record deleted." });
            loadDoctors();
        } catch (err) {
            console.error("Failed to delete doctor:", err);
            setStatusMessage({ type: "danger", msg: "Failed to delete doctor." });
        }
    };

    const handleFilterBySpec = async () => {
        if (!searchSpec.trim()) {
            loadDoctors();
            return;
        }
        try {
            const response = await getDoctorsBySpecialization(searchSpec.trim());
            setDoctors(Array.isArray(response.data) ? response.data : []);
        } catch (err) {
            console.error("Specialization filter error:", err);
            setStatusMessage({ type: "danger", msg: "Error fetching doctors by specialization." });
            setDoctors([]);
        }
    };

    const handleFilterByHospital = async () => {
        if (!searchHospitalId) {
            loadDoctors();
            return;
        }
        try {
            const response = await getDoctorsByHospitalId(searchHospitalId);
            setDoctors(Array.isArray(response.data) ? response.data : []);
        } catch (err) {
            console.error("Hospital filter error:", err);
            setStatusMessage({ type: "danger", msg: "Error fetching doctors for this Hospital ID." });
            setDoctors([]);
        }
    };

    const resetForm = () => {
        setEditingId(null);
        setDoctorName("");
        setSpecialization("");
    };

    const resetFilters = () => {
        setSearchSpec("");
        setSearchHospitalId("");
        loadDoctors();
    };

    if (loading) return <div className="container mt-4"><h3 className="text-dark">Loading doctors...</h3></div>;
    if (error) return <div className="container mt-4 alert alert-danger"><h3>{error}</h3></div>;

    return (
        <div className="container mt-4">
            <h2 className="mb-4 text-dark fw-bold">Doctor Management</h2>

            {statusMessage.msg && (
                <div className={`alert alert-${statusMessage.type} alert-dismissible fade show`} role="alert">
                    {statusMessage.msg}
                    <button type="button" className="btn-close" onClick={() => setStatusMessage({ type: "", msg: "" })}></button>
                </div>
            )}

            {/* Form */}
            <div className="card mb-4 shadow-sm border-0">
                <div className={`card-header text-white ${editingId ? "bg-warning text-dark" : "bg-primary"}`}>
                    <h5 className="mb-0">{editingId ? `Editing Doctor (ID: ${editingId})` : "Add New Doctor"}</h5>
                </div>
                <div className="card-body">
                    <form onSubmit={handleFormSubmit} className="row g-3">
                        <div className="col-md-5">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Doctor Name"
                                value={doctorName}
                                onChange={(e) => setDoctorName(e.target.value)}
                                required
                            />
                        </div>
                        <div className="col-md-4">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Specialization (e.g., Cardiology)"
                                value={specialization}
                                onChange={(e) => setSpecialization(e.target.value)}
                                required
                            />
                        </div>
                        <div className="col-md-3 d-flex gap-2">
                            <button type="submit" className={`btn ${editingId ? "btn-warning" : "btn-success"} w-100`} disabled={submitting}>
                                {submitting ? "Processing..." : editingId ? "Update" : "Add Doctor"}
                            </button>
                            {editingId && (
                                <button type="button" className="btn btn-secondary" onClick={resetForm}>
                                    Cancel
                                </button>
                            )}
                        </div>
                    </form>
                </div>
            </div>

            {/* Filter Controls */}
            <div className="row mb-4">
                <div className="col-md-5">
                    <div className="input-group">
                        <input
                            type="text"
                            className="form-control"
                            placeholder="Filter by Specialization"
                            value={searchSpec}
                            onChange={(e) => setSearchSpec(e.target.value)}
                        />
                        <button className="btn btn-outline-primary" onClick={handleFilterBySpec}>Search</button>
                    </div>
                </div>
                <div className="col-md-5">
                    <div className="input-group">
                        <input
                            type="number"
                            className="form-control"
                            placeholder="Filter by Hospital ID"
                            value={searchHospitalId}
                            onChange={(e) => setSearchHospitalId(e.target.value)}
                        />
                        <button className="btn btn-outline-primary" onClick={handleFilterByHospital}>Search</button>
                    </div>
                </div>
                <div className="col-md-2">
                    <button className="btn btn-secondary w-100" onClick={resetFilters}>Reset All</button>
                </div>
            </div>

            {/* Table */}
            <div className="table-responsive shadow-sm">
                <table className="table table-bordered table-hover align-middle mb-0 bg-white">
                    <thead className="table-dark">
                        <tr>
                            <th style={{ width: "10%" }}>ID</th>
                            <th style={{ width: "40%" }}>Doctor Name</th>
                            <th style={{ width: "30%" }}>Specialization</th>
                            <th style={{ width: "20%" }} className="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {Array.isArray(doctors) && doctors.length > 0 ? (
                            doctors.map((doc) => (
                                <tr key={doc.doctorId}>
                                    <td>{doc.doctorId}</td>
                                    <td className="fw-semibold">{doc.doctorName}</td>
                                    <td>{doc.specialization}</td>
                                    <td className="text-center">
                                        <button
                                            className="btn btn-sm btn-outline-primary me-2"
                                            onClick={() => handleEditClick(doc)}
                                        >
                                            Edit
                                        </button>
                                        <button
                                            className="btn btn-sm btn-outline-danger"
                                            onClick={() => handleDeleteClick(doc.doctorId)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="4" className="text-center text-muted py-4">No doctors found.</td>
                            </tr>
                        )}  
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Doctors;