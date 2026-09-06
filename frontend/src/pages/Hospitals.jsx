import { useEffect, useState } from "react";
import { getAllHospitals, saveHospital, updateHospital, deleteHospital } from "../services/hospitalService";

function Hospitals() {
    const [hospitals, setHospitals] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState("");
    const [statusMessage, setStatusMessage] = useState({ type: "", msg: "" });

    // Form State
    const [hospitalName, setHospitalName] = useState("");
    const [location, setLocation] = useState("");
    const [editingId, setEditingId] = useState(null);
    const [submitting, setSubmitting] = useState(false);

    useEffect(() => {
        loadHospitals();
    }, []);

    const loadHospitals = async () => {
        try {
            const response = await getAllHospitals();
            setHospitals(response.data);
        } catch (err) {
            console.error(err);
            setError("Failed to load hospitals.");
        } finally {
            setLoading(false);
        }
    };

    const handleFormSubmit = async (e) => {
        e.preventDefault();
        if (!hospitalName.trim() || !location.trim()) return;

        setSubmitting(true);
        setStatusMessage({ type: "", msg: "" });

        try {
            const hospitalData = { hospitalName, location };
            
            if (editingId) {
                await updateHospital(editingId, hospitalData);
                setStatusMessage({ type: "success", msg: "Hospital updated successfully!" });
            } else {
                await saveHospital(hospitalData);
                setStatusMessage({ type: "success", msg: "Hospital added successfully!" });
            }

            resetForm();
            loadHospitals();
        } catch (err) {
            console.error(err);
            setStatusMessage({ type: "danger", msg: "Operation failed. Check backend." });
        } finally {
            setSubmitting(false);
        }
    };

    const handleEditClick = (hospital) => {
        setEditingId(hospital.hospitalId);
        setHospitalName(hospital.hospitalName);
        setLocation(hospital.location);
    };

    const handleDeleteClick = async (hospitalId) => {
        if (!window.confirm(`Delete hospital ID ${hospitalId}?`)) return;

        try {
            await deleteHospital(hospitalId);
            setStatusMessage({ type: "warning", msg: "Hospital record deleted." });
            loadHospitals();
        } catch (err) {
            console.error(err);
            setStatusMessage({ type: "danger", msg: "Failed to delete hospital." });
        }
    };

    const resetForm = () => {
        setEditingId(null);
        setHospitalName("");
        setLocation("");
    };

    if (loading) return <div className="container mt-4"><h3>Loading hospitals...</h3></div>;
    if (error) return <div className="container mt-4 alert alert-danger"><h3>{error}</h3></div>;

    return (
        <div className="container mt-4">
            <h2 className="mb-4 text-dark fw-bold">Hospital Management</h2>

            {statusMessage.msg && (
                <div className={`alert alert-${statusMessage.type} alert-dismissible fade show`} role="alert">
                    {statusMessage.msg}
                    <button type="button" className="btn-close" onClick={() => setStatusMessage({ type: "", msg: "" })}></button>
                </div>
            )}

            {/* Input Form */}
            <div className="card mb-4 shadow-sm border-0">
                <div className={`card-header text-white ${editingId ? "bg-warning" : "bg-primary"}`}>
                    <h5 className="mb-0">{editingId ? `Editing Hospital (ID: ${editingId})` : "Add New Hospital"}</h5>
                </div>
                <div className="card-body">
                    <form onSubmit={handleFormSubmit} className="row g-3">
                        <div className="col-md-5">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Hospital Name"
                                value={hospitalName}
                                onChange={(e) => setHospitalName(e.target.value)}
                                required
                            />
                        </div>
                        <div className="col-md-4">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Location"
                                value={location}
                                onChange={(e) => setLocation(e.target.value)}
                                required
                            />
                        </div>
                        <div className="col-md-3 d-flex gap-2">
                            <button type="submit" className={`btn ${editingId ? "btn-warning" : "btn-success"} w-100`} disabled={submitting}>
                                {submitting ? "Processing..." : editingId ? "Update" : "Add Hospital"}
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

            {/* Table */}
            <div className="table-responsive shadow-sm">
                <table className="table table-bordered table-hover align-middle mb-0">
                    <thead className="table-dark">
                        <tr>
                            <th style={{ width: "10%" }}>ID</th>
                            <th style={{ width: "40%" }}>Hospital Name</th>
                            <th style={{ width: "30%" }}>Location</th>
                            <th style={{ width: "20%" }} className="text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {hospitals.length > 0 ? (
                            hospitals.map((hospital) => (
                                <tr key={hospital.hospitalId}>
                                    <td>{hospital.hospitalId}</td>
                                    <td className="fw-semibold">{hospital.hospitalName}</td>
                                    <td>{hospital.location}</td>
                                    <td className="text-center">
                                        <button
                                            className="btn btn-sm btn-outline-primary me-2"
                                            onClick={() => handleEditClick(hospital)}
                                        >
                                            Edit
                                        </button>
                                        <button
                                            className="btn btn-sm btn-outline-danger"
                                            onClick={() => handleDeleteClick(hospital.hospitalId)}
                                        >
                                            Delete
                                        </button>
                                    </td>
                                </tr>
                            ))
                        ) : (
                            <tr>
                                <td colSpan="4" className="text-center text-muted py-4">No hospitals found.</td>
                            </tr>
                        )}
                    </tbody>
                </table>
            </div>
        </div>
    );
}

export default Hospitals;