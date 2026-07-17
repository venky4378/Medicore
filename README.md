# 🏥 Hospital Management System

A RESTful Hospital Management System developed using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. The application provides APIs for managing hospitals, doctors, patients, and appointments while demonstrating CRUD operations, entity relationships, layered architecture, and centralized exception handling.

---

## 📖 Project Overview

The Hospital Management System is designed to streamline hospital administration by managing hospitals, doctors, patients, and appointments through REST APIs.

This project follows a layered architecture consisting of:

- Controller Layer
- Service Layer
- Repository Layer
- Model Layer

It demonstrates backend development using Spring Boot and database integration using Spring Data JPA and MySQL.

---

## ✨ Features

### 🏥 Hospital Management
- Create Hospital
- View All Hospitals
- Get Hospital by ID
- Search Hospital by Name
- Search Hospitals by Location
- Update Hospital
- Delete Hospital

### 👨‍⚕️ Doctor Management
- Add Doctor
- View All Doctors
- Search Doctor by ID
- Search Doctors by Hospital
- Search Doctors by Name
- Search Doctors by Specialization
- Update Doctor
- Delete Doctor

### 🧑 Patient Management
- Register Patient
- View All Patients
- Get Patient by ID
- Search Patient by Doctor
- Search Patient by Hospital
- Search Patient by Phone Number
- Update Patient
- Delete Patient

### 📅 Appointment Management
- Schedule Appointment
- View All Appointments
- Get Appointment by ID
- View Appointments by Doctor
- View Appointments by Patient
- View Appointments by Date
- View Appointments by Status
- Update Appointment
- Cancel Appointment

### ⚙ Additional Features

- RESTful API Development
- Layered Architecture
- Spring Data JPA
- Hibernate ORM
- MySQL Database Integration
- Global Exception Handling
- Custom Repository Query Methods

---

# 🛠 Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Postman
- Eclipse IDE

---

# 📂 Project Structure

```
src
└── main
    ├── java
    │   └── com.vcube.hospitalmanagementapp
    │       ├── controller
    │       ├── service
    │       ├── serviceimpl
    │       ├── repo
    │       ├── model
    │       ├── exception
    │       └── MedicoreApplication.java
    │
    └── resources
        └── application.properties
```

---

# 🗄 Database

### Database

```
hospital
```

### Tables

- Hospital
- Doctor
- Patient
- Appointment

### Entity Relationships

- One Hospital ➜ Many Doctors
- One Doctor ➜ Many Appointments
- One Patient ➜ Many Appointments

---

# 🚀 REST API Endpoints

## 🏥 Hospital APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/hospital/api/v1/savehospital` | Create Hospital |
| GET | `/hospital/api/v1/getAllHospitals` | Get All Hospitals |
| GET | `/hospital/api/v1/getHospitalById/{hospitalId}` | Get Hospital by ID |
| GET | `/hospital/api/v1/getHospitalByName/{hospitalName}` | Search Hospital by Name |
| GET | `/hospital/api/v1/getHospitalByLocation/{location}` | Search Hospital by Location |
| PUT | `/hospital/api/v1/updateHospital/{hospitalId}` | Update Hospital |
| DELETE | `/hospital/api/v1/deleteHospital/{hospitalId}` | Delete Hospital |

---

## 👨‍⚕️ Doctor APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/doctor/api/v1/saveDoctor` | Add Doctor |
| GET | `/doctor/api/v1/getAllDoctors` | Get All Doctors |
| GET | `/doctor/api/v1/getDoctorById/{doctorId}` | Get Doctor by ID |
| GET | `/doctor/api/v1/getDoctorsByHospital/{hospitalId}` | Get Doctors by Hospital |
| GET | `/doctor/api/v1/getDoctorName/{doctorName}` | Search Doctor by Name |
| GET | `/doctor/api/v1/getBySpecialization/{specialization}` | Search Doctor by Specialization |
| PUT | `/doctor/api/v1/updateDoctor/{doctorId}` | Update Doctor |
| DELETE | `/doctor/api/v1/deleteDoctor/{doctorId}` | Delete Doctor |

---

## 🧑 Patient APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/patient/api/v1/savePatient` | Register Patient |
| GET | `/patient/api/v1/getAllPatients` | Get All Patients |
| GET | `/patient/api/v1/getPatientById/{patientId}` | Get Patient by ID |
| GET | `/patient/api/v1/getPatientByDoctor/{doctorId}` | Get Patient by Doctor |
| GET | `/patient/api/v1/getPatientByHospital/{hospitalId}` | Get Patient by Hospital |
| GET | `/patient/api/v1/getPatientByPhone/{phone}` | Get Patient by Phone |
| PUT | `/patient/api/v1/updatePatient/{patientId}` | Update Patient |
| DELETE | `/patient/api/v1/deletePatient/{patientId}` | Delete Patient |

---

## 📅 Appointment APIs

| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/appointment/api/v1/saveAppointment` | Create Appointment |
| GET | `/appointment/api/v1/getAllAppointments` | Get All Appointments |
| GET | `/appointment/api/v1/getAppointmentById/{appointmentId}` | Get Appointment by ID |
| GET | `/appointment/api/v1/getAppointmentsByDoctor/{doctorId}` | Get Appointments by Doctor |
| GET | `/appointment/api/v1/getAppointmentsByPatient/{patientId}` | Get Appointments by Patient |
| GET | `/appointment/api/v1/getAppointmentsByDate/{appointmentDate}` | Get Appointments by Date |
| GET | `/appointment/api/v1/getAppointmentsByStatus/{status}` | Get Appointments by Status |
| PUT | `/appointment/api/v1/updateAppointment/{appointmentId}` | Update Appointment |
| DELETE | `/appointment/api/v1/deleteAppointment/{appointmentId}` | Delete Appointment |

---

# ⚙ Configuration

Configure your database in:

```
application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

# ▶ How to Run

### Clone Repository

```bash
git clone https://github.com/venky4378/Medicore.git
```

### Open Project

Import the project into Eclipse or IntelliJ IDEA.

### Configure Database

Create the MySQL database and update the credentials in `application.properties`.

### Run Application

Run the `MedicoreApplication.java` class.

### Test APIs

Use Postman to test the REST APIs.

---

# 📚 Concepts Implemented

- Spring Boot
- REST API Development
- Spring Data JPA
- Hibernate ORM
- CRUD Operations
- Layered Architecture
- Dependency Injection
- Entity Relationships
- Repository Pattern
- Exception Handling
- Custom Query Methods
- Maven Project Structure

---

# 🚀 Future Enhancements

- Spring Security
- JWT Authentication
- Swagger/OpenAPI Documentation
- Request Validation
- Pagination & Sorting
- Logging (SLF4J)
- Unit Testing (JUnit & Mockito)
- Docker Support
- React Frontend
- Role-Based Access Control (Admin, Doctor, Patient)

---

# 👨‍💻 Author

**Swamy Ch**

**GitHub**
- https://github.com/venky4378

**LinkedIn**
- https://www.linkedin.com/in/swamy-ch/

---

# ⭐ Support

If you found this project useful, please consider giving this repository a ⭐ on GitHub.
