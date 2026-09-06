import api from "./api";

export const getAllHospitals = () => {
    return api.get("/hospital/api/v1/getAllHospitals");
};

export const getHospitalById = (hospitalId) => {
    return api.get(
        `/hospital/api/v1/getByHospitalById/${hospitalId}`
    );
};

export const saveHospital = (hospital) => {
    return api.post(
        "/hospital/api/v1/savehospital",
        hospital
    );
};

export const updateHospital = (hospitalId, hospital) => {
    return api.put(
        `/hospital/api/v1/updatehospital/${hospitalId}`,
        hospital
    );
};

export const deleteHospital = (hospitalId) => 
    api.delete(`/hospital/api/v1/deletehospital/${hospitalId}`);