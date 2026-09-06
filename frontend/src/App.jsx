import { BrowserRouter as Router, Routes, Route, Navigate } from "react-router-dom";
import Navbar from "./components/Navbar";
import Hospitals from "./pages/Hospitals";
import Patients from "./pages/Patients";
import Doctors from "./pages/Doctors";
import Appointments from "./pages/Appointments";

function App() {
    return (
        <Router>
            <Navbar />
            <Routes>
                <Route path="/" element={<Navigate to="/hospitals" />} />
                <Route path="/hospitals" element={<Hospitals />} />
                <Route path="/doctors" element={<Doctors />} />
                <Route path="/patients" element={<Patients />} />
                <Route path="/appointments" element={<Appointments />} />
            </Routes>
        </Router>
    );
}

export default App;