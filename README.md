# MediCore — Full-Stack Hospital Management System

MediCore is a full-stack Hospital Management System built using **Java, Spring Boot, React (Vite), and MySQL**.

The application provides modules for managing **Hospitals, Doctors, Patients, and Appointments**. The React frontend communicates with the Spring Boot backend through REST APIs, while **Spring Data JPA and Hibernate** handle persistence and relational database operations.

The project demonstrates practical full-stack development concepts including **REST API development, CRUD operations, JPA entity relationships, JSON serialization, exception handling, AOP-based logging, CORS configuration, React state management, and Axios-based API integration**.

---

## 📌 Project Overview

MediCore is designed to manage basic hospital administration workflows through a web-based interface.

### Main Modules

* 🏥 Hospital Management
* 👨‍⚕️ Doctor Management
* 🧑 Patient Management
* 📅 Appointment Scheduling

### Application Flow

```text
User
 │
 ▼
React Frontend
 │
 │ HTTP / Axios
 ▼
Spring Boot REST Controller
 │
 ▼
Service Layer
 │
 ▼
Repository Layer
 │
 ▼
MySQL Database
 │
 ▼
JSON Response
 │
 ▼
React State
 │
 ▼
Updated UI
```

---

# 🏗️ Architecture

```text
┌──────────────────────────────┐
│       React + Vite           │
│          Frontend             │
└──────────────┬───────────────┘
               │
               │ REST / HTTP
               ▼
┌──────────────────────────────┐
│       Spring Boot            │
│     REST Controllers         │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│       Service Layer          │
│       Business Logic         │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│      Repository Layer        │
│      Spring Data JPA         │
└──────────────┬───────────────┘
               │
               ▼
┌──────────────────────────────┐
│        MySQL Database        │
└──────────────────────────────┘
```

---

# ✨ Features

## 🏥 Hospital Management

The Hospital module supports:

* Add hospital
* View all hospitals
* Update hospital
* Delete hospital
* Display hospital records in a table
* Loading state while retrieving data
* Error handling
* Success and failure messages
* Confirmation before deleting records

---

## 👨‍⚕️ Doctor Management

The Doctor module supports:

* Add doctor
* View all doctors
* Update doctor
* Delete doctor
* Filter doctors by specialization
* Filter doctors by hospital ID
* Reset filters
* Loading and error handling
* Form state management
* Success and error messages

The React Doctor page maintains doctor data, form values, loading state, error state, editing state, and filter values using React state.

Doctor operations are connected to separate service functions for retrieving, creating, updating, deleting, and filtering doctor data.

---

## 🧑 Patient Management

The Patient module supports:

* Register/add patient
* View all patients
* Delete patient
* Patient name
* Age
* Disease/condition
* Loading state
* Error handling
* Confirmation before deletion

When a patient is added, the frontend sends the patient information to the backend and refreshes the patient list.

Example request:

```json
{
  "patientName": "John",
  "age": 35,
  "disease": "Fever"
}
```

---

## 📅 Appointment Scheduling

The Appointment module supports:

* Book appointments
* Select a patient
* Select a doctor
* Select appointment date
* Set appointment status
* Display scheduled appointments
* Cancel appointments

### Appointment Flow

```text
Select Patient
      │
      ▼
Select Doctor
      │
      ▼
Select Date
      │
      ▼
Create Appointment
      │
      ▼
POST Request
      │
      ▼
Spring Boot API
      │
      ▼
Database
      │
      ▼
Refresh Appointment List
```

An appointment connects a patient and doctor through their IDs.

Example request:

```json
{
  "appointmentDate": "2026-09-10",
  "status": "Booked",
  "patient": {
    "patientId": 1
  },
  "doctor": {
    "doctorId": 2
  }
}
```

---

# ⚛️ React Frontend

The frontend is developed using:

* **React.js**
* **Vite**
* **React Router**
* **Axios**
* **Bootstrap**
* **JavaScript ES6+**

## React Hooks

### `useState`

`useState` is used to store and update component data.

Example:

```javascript
const [doctors, setDoctors] = useState([]);
```

Here:

```text
doctors
   ↓
Current state

setDoctors(...)
   ↓
Updates the state
```

### `useEffect`

`useEffect` is used to perform actions when a component is loaded.

Example:

```javascript
useEffect(() => {
    loadDoctors();
}, []);
```

This loads doctor information when the Doctor page is mounted.

---

# 🌐 React Routing

React Router is used to navigate between the application modules.

```text
/
│
└── /hospitals

/doctors

/patients

/appointments
```

The navigation structure is:

```text
Hospital System
│
├── Hospitals
├── Doctors
├── Patients
└── Appointments
```

---

# 🔌 API Integration

Axios is used for communication between the React frontend and Spring Boot backend.

API calls are organized into service functions.

Example:

```javascript
export const saveDoctor = (doctorData) =>
    api.post("/doctor/api/v1/savedoctor", doctorData);
```

The React component can then call:

```javascript
await saveDoctor(doctorData);
```

This keeps API communication separate from the UI component.

### API Request Flow

```text
React Component
       │
       ▼
Service Function
       │
       ▼
Axios
       │
       ▼
Spring Boot REST API
       │
       ▼
Controller
       │
       ▼
Service
       │
       ▼
Repository
       │
       ▼
MySQL
```

### Response Flow

```text
MySQL
  ↓
Repository
  ↓
Service
  ↓
Controller
  ↓
JSON Response
  ↓
Axios
  ↓
React State
  ↓
UI
```

---

# 🗂️ Frontend Project Structure

```text
frontend/
│
├── src/
│   │
│   ├── components/
│   │   └── Navbar.jsx
│   │
│   ├── pages/
│   │   ├── Hospitals.jsx
│   │   ├── Doctors.jsx
│   │   ├── Patients.jsx
│   │   └── Appointments.jsx
│   │
│   ├── services/
│   │   ├── api.js
│   │   ├── hospitalService.js
│   │   ├── doctorService.js
│   │   ├── patientService.js
│   │   └── appointmentService.js
│   │
│   ├── App.jsx
│   ├── index.css
│   └── main.jsx
│
└── package.json
```

---

# ☕ Spring Boot Backend

The backend is developed using:

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate ORM
* Spring AOP
* REST APIs
* Lombok
* Maven

The backend follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
MySQL
```

---

# 📂 Backend Project Structure

```text
src/
└── main/
    │
    ├── java/
    │   └── com/vcube/hospitalmanagementapp/
    │       │
    │       ├── config/
    │       │
    │       ├── controller/
    │       │
    │       ├── exception/
    │       │
    │       ├── model/
    │       │
    │       ├── repo/
    │       │
    │       ├── service/
    │       │
    │       └── serviceimpl/
    │
    └── resources/
        └── application.properties
```

---

# 🗄️ Database & Entity Relationships

The application uses **MySQL** as the relational database.

### Main Entities

```text
Hospital
Doctor
Patient
Appointment
```

### Current JPA Relationships

```text
Hospital
   ▲
   │
   │ Many Doctors reference one Hospital
   │
Doctor
   │
   │ One Doctor has many Appointments
   ▼
Appointment
   ▲
   │
   │ Many Appointments reference one Patient
   │
Patient
```

### Relationship Details

#### Doctor → Hospital

```java
@ManyToOne
@JoinColumn(name = "hospitalId")
private Hospital hospital;
```

Multiple doctors can reference the same hospital.

#### Doctor → Appointment

```java
@OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL)
private List<Appointment> appointments;
```

One doctor can have multiple appointments.

#### Patient → Appointment

```java
@OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
private List<Appointment> appointments;
```

One patient can have multiple appointments.

#### Appointment → Doctor

```java
@ManyToOne
@JoinColumn(name = "doctor_id")
private Doctor doctor;
```

#### Appointment → Patient

```java
@ManyToOne
@JoinColumn(name = "patient_id")
private Patient patient;
```

---

# 🔁 Circular JSON Serialization

Bi-directional relationships can cause recursive JSON serialization.

For example:

```text
Doctor
   ↓
Appointments
   ↓
Doctor
   ↓
Appointments
   ↓
...
```

Similarly, appointment relationships can reference Patient and Doctor objects.

This can result in serialization problems such as:

```text
HttpMessageNotWritableException
```

Jackson's `@JsonIgnoreProperties` annotation is used on the related entity fields to control which properties are serialized.

For example:

```java
@JsonIgnoreProperties({"appointments", "hibernateLazyInitializer", "handler"})
private Patient patient;
```

This prevents unnecessary recursive traversal of related objects when converting entities to JSON.

---

# 🧩 Aspect-Oriented Programming

Spring AOP is used for centralized logging and cross-cutting concerns.

Instead of placing logging logic inside every service method, logging can be handled separately using an aspect.

Conceptually:

```text
Service Method
      │
      ▼
     AOP
      │
      ├── Method Execution Logging
      │
      └── Exception Logging
```

This separates logging concerns from the main business logic.

---

# ⚠️ Global Exception Handling

The backend uses Spring's centralized exception handling mechanisms:

```java
@ControllerAdvice
@ExceptionHandler
```

This allows exceptions to be handled in a central location instead of duplicating error-handling code across controllers.

---

# 🌐 CORS

The React frontend and Spring Boot backend run on different development ports.

```text
React Frontend
localhost:5173
      │
      │ HTTP Request
      ▼
Spring Boot Backend
localhost:9900
```

CORS configuration allows the frontend to communicate with the backend during development.

---

# 🚀 REST API Endpoints

## 🏥 Hospital APIs

| Method | Endpoint                                            | Description                  |
| ------ | --------------------------------------------------- | ---------------------------- |
| POST   | `/hospital/api/v1/savehospital`                     | Create Hospital              |
| GET    | `/hospital/api/v1/getAllHospitals`                  | Get All Hospitals            |
| GET    | `/hospital/api/v1/getHospitalById/{hospitalId}`     | Get Hospital by ID           |
| GET    | `/hospital/api/v1/getHospitalByName/{hospitalName}` | Search Hospital by Name      |
| GET    | `/hospital/api/v1/getHospitalByLocation/{location}` | Search Hospitals by Location |
| PUT    | `/hospital/api/v1/updateHospital/{hospitalId}`      | Update Hospital              |
| DELETE | `/hospital/api/v1/deleteHospital/{hospitalId}`      | Delete Hospital              |

---

## 👨‍⚕️ Doctor APIs

| Method | Endpoint                                              | Description              |
| ------ | ----------------------------------------------------- | ------------------------ |
| POST   | `/doctor/api/v1/savedoctor`                           | Add Doctor               |
| GET    | `/doctor/api/v1/getAllDoctors`                        | Get All Doctors          |
| GET    | `/doctor/api/v1/getDoctorName/{doctorName}`           | Search Doctor by Name    |
| GET    | `/doctor/api/v1/getBySpecialization/{specialization}` | Search by Specialization |
| GET    | `/doctor/api/v1/getDoctorById/{hospitalId}`           | Get Doctors by Hospital  |
| PUT    | `/doctor/api/v1/updatedoctor/{doctorId}`              | Update Doctor            |
| DELETE | `/doctor/api/v1/deletedoctor/{doctorId}`              | Delete Doctor            |

---

## 🧑 Patient APIs

| Method | Endpoint                                            | Description              |
| ------ | --------------------------------------------------- | ------------------------ |
| POST   | `/patient/api/v1/savePatient`                       | Register Patient         |
| GET    | `/patient/api/v1/getAllPatients`                    | Get All Patients         |
| GET    | `/patient/api/v1/getPatientById/{patientId}`        | Get Patient by ID        |
| GET    | `/patient/api/v1/getPatientByDoctor/{doctorId}`     | Get Patients by Doctor   |
| GET    | `/patient/api/v1/getPatientByHospital/{hospitalId}` | Get Patients by Hospital |
| GET    | `/patient/api/v1/getPatientByPhone/{phone}`         | Search Patient by Phone  |
| PUT    | `/patient/api/v1/updatePatient/{patientId}`         | Update Patient           |
| DELETE | `/patient/api/v1/deletePatient/{patientId}`         | Delete Patient           |

---

## 📅 Appointment APIs

| Method | Endpoint                                                | Description               |
| ------ | ------------------------------------------------------- | ------------------------- |
| POST   | `/appointment/api/v1/saveappointment`                   | Schedule Appointment      |
| GET    | `/appointment/api/v1/getappointments`                   | Get All Appointments      |
| GET    | `/appointment/api/v1/getappointment/{appointmentId}`    | Get Appointment by ID     |
| PATCH  | `/appointment/api/v1/updateappointment/{appointmentId}` | Update Appointment        |
| DELETE | `/appointment/api/v1/deleteappointment/{appointmentId}` | Cancel/Delete Appointment |

---

# 🧪 API Testing

The REST APIs can be tested using **Postman**.

Example:

```text
POST http://localhost:9900/doctor/api/v1/savedoctor
```

Example request body:

```json
{
  "doctorName": "Dr. Smith",
  "specialization": "Cardiology"
}
```

---

# ⚙️ Setup & Installation

## Prerequisites

Install the following:

* Java 17+
* Maven
* MySQL
* Node.js
* npm
* Git

---

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/venky4378/Medicore.git
cd Medicore
```

---

## 2️⃣ Create MySQL Database

Create the database:

```sql
CREATE DATABASE hospital;
```

---

## 3️⃣ Configure Database

Open:

```text
src/main/resources/application.properties
```

Configure your MySQL credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

server.port=9900
```

### ⚠️ Security Note

Do **not** commit your real database password to GitHub.

For production applications, use environment variables or secure configuration.

---

## 4️⃣ Start Spring Boot Backend

Using Maven:

```bash
mvn spring-boot:run
```

Or run the main Spring Boot application from your IDE.

Backend:

```text
http://localhost:9900
```

---

## 5️⃣ Start React Frontend

Open another terminal:

```bash
cd frontend
```

Install dependencies:

```bash
npm install
```

Start the Vite development server:

```bash
npm run dev
```

The terminal will display the frontend URL, typically:

```text
http://localhost:5173
```

---

# 🔄 Example Full-Stack Operation

Consider adding a doctor.

### Step 1 — User enters data

```text
Doctor Name: Dr. Smith
Specialization: Cardiology
```

### Step 2 — React stores the form values

React uses `useState` to maintain the form data.

### Step 3 — User clicks Add Doctor

The component creates:

```javascript
const doctorData = {
    doctorName,
    specialization
};
```

### Step 4 — Service function is called

```javascript
saveDoctor(doctorData);
```

### Step 5 — Axios sends HTTP request

```text
POST /doctor/api/v1/savedoctor
```

### Step 6 — Spring Boot receives the request

```text
Controller
    ↓
Service
    ↓
Repository
```

### Step 7 — JPA saves the entity

```text
Repository
    ↓
Hibernate
    ↓
MySQL
```

### Step 8 — Backend returns response

```text
MySQL
    ↓
Repository
    ↓
Service
    ↓
Controller
    ↓
JSON Response
```

### Step 9 — React refreshes the data

```text
JSON Response
      ↓
setDoctors(...)
      ↓
React re-renders
      ↓
Updated Doctor Table
```

This request-response cycle is the core integration pattern used throughout the application.

---

# 🧠 Key Concepts Demonstrated

## Backend

* Java
* Spring Boot
* REST APIs
* Layered architecture
* Spring Data JPA
* Hibernate ORM
* MySQL
* CRUD operations
* JPA entity relationships
* Derived / custom queries
* Spring AOP
* Exception handling
* CORS
* Lombok

## Frontend

* React.js
* Vite
* React Router
* React components
* `useState`
* `useEffect`
* Controlled forms
* Conditional rendering
* Axios
* REST API integration
* Loading and error states
* Bootstrap
* JavaScript ES6+

## Full-Stack Integration

* React-to-Spring Boot communication
* HTTP requests and responses
* JSON data exchange
* Relational data handling
* Frontend state updates
* CORS configuration
* REST API consumption

---

# 📚 What This Project Helped Me Understand

Through this project, I gained practical exposure to:

* Designing a layered Spring Boot application
* Creating REST APIs
* Connecting Java applications with MySQL
* Mapping entity relationships using JPA
* Handling recursive JSON serialization
* Separating cross-cutting logging concerns using AOP
* Centralizing exception handling
* Connecting a React frontend to REST APIs
* Managing frontend state
* Handling asynchronous API requests
* Displaying backend data dynamically in React

---

# 🚀 Future Enhancements

Potential improvements for future versions include:

* Spring Security
* JWT authentication
* Role-based authorization
* Admin, Doctor, and Patient roles
* Swagger / OpenAPI documentation
* JUnit 5 unit testing
* Mockito testing
* Integration testing
* Bean Validation
* Pagination and sorting
* Improved appointment validation
* Centralized frontend environment configuration
* Docker containerization
* CI/CD pipeline
* Cloud deployment

---

# 👨‍💻 Author

**Swamy Ch**

GitHub: [venky4378](https://github.com/venky4378)

---

# ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub.
