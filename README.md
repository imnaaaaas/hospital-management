# Hospital Management System - Backend

A comprehensive Spring Boot backend application for managing hospital operations, including patient records, doctor information, appointments, prescriptions, and more.

## Tech Stack

- **Language**: Java 17
- **Framework**: Spring Boot 3.5.1
- **Security**: Spring Security with JWT
- **ORM**: Spring Data JPA
- **Database**: PostgreSQL
- **Build Tool**: Maven
- **Additional Libraries**: Lombok

## Features

### Authentication & Authorization
- **JWT Authentication**: Secure token-based authentication system
- **User Registration**: New user account creation
- **User Login**: Credential-based login with JWT token generation
- **Role-Based Access Control**: Four distinct user roles
  - `ADMIN`: Full system access and administration capabilities
  - `DOCTOR`: Access to patient records, appointments, and prescriptions
  - `RECEPTIONIST`: Appointment scheduling and patient check-in
  - `PATIENT`: Access to personal records and appointment history

### Core Functionality
- **Patient Management**: Complete CRUD operations for patient records
- **Doctor Management**: Doctor profile and specialization management
- **Department Management**: Hospital department organization
- **Appointment Management**: Schedule, reschedule, and cancel appointments
- **Prescription Management**: Create and manage patient prescriptions

### System Features
- **Pagination Support**: Efficient data retrieval for large datasets
- **Input Validation**: Comprehensive request validation
- **Global Exception Handling**: Centralized error handling and response formatting
- **RESTful API**: Clean and intuitive API design

## Project Structure

```
src/main/java/ge/ibsu/hospital/
├── controllers/          # REST API endpoints
│   ├── AppointmentController.java
│   ├── DepartmentController.java
│   ├── DoctorController.java
│   ├── PatientController.java
│   ├── PrescriptionController.java
│   └── GlobalExceptionHandler.java
├── entities/            # JPA entities (database models)
│   ├── Appointment.java
│   ├── Department.java
│   ├── Doctor.java
│   ├── Patient.java
│   ├── Prescription.java
│   └── User.java
├── enums/              # Enumeration types
│   ├── AppointmentStatus.java
│   ├── BloodType.java
│   ├── Gender.java
│   ├── Role.java
│   └── Specialization.java
├── repositories/        # Spring Data JPA repositories
│   ├── AppointmentRepository.java
│   ├── DepartmentRepository.java
│   ├── DoctorRepository.java
│   ├── PatientRepository.java
│   ├── PrescriptionRepository.java
│   └── UserRepository.java
├── security/           # Authentication & authorization
│   ├── config/         # Security configuration
│   │   ├── ApplicationConfig.java
│   │   ├── JwtAuthenticationFilter.java
│   │   ├── JwtService.java
│   │   └── SecurityConfiguration.java
│   ├── controller/      # Security endpoints
│   │   └── UserController.java
│   ├── dto/            # Data transfer objects
│   │   ├── AuthenticationResponse.java
│   │   ├── LoginData.java
│   │   └── RegistrationRequest.java
│   └── services/        # Security services
│       └── UserService.java
└── services/           # Business logic services
    ├── AppointmentService.java
    ├── DepartmentService.java
    ├── DoctorService.java
    ├── PatientService.java
    └── PrescriptionService.java
```

### Directory Explanation

- **Controllers**: Handle incoming HTTP requests and return responses
- **Entities**: JPA-annotated classes representing database tables
- **Enums**: Define constant values used throughout the application
- **Repositories**: Data access layer interfaces for database operations
- **Security**: JWT authentication, authorization, and user management
- **Services**: Business logic and application workflows

## Getting Started

### Prerequisites

- Java 17 or higher
- PostgreSQL database server
- Maven 3.6 or higher

### Installation

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd hospital-management
   ```

2. **Create PostgreSQL Database**
   ```sql
   CREATE DATABASE hospital_db;
   ```

3. **Update Database Configuration**
   
   Edit `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/hospital_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password
   ```

4. **Run the Application**
   ```bash
   ./mvnw spring-boot:run
   ```

   The application will start on `http://localhost:8080`

## API Endpoints

### Authentication Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | User login (returns JWT token) |

### Patient Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/patients` | Get all patients (paginated) |
| GET | `/api/patients/{id}` | Get patient by ID |
| POST | `/api/patients` | Create new patient |
| PUT | `/api/patients/{id}` | Update patient |
| DELETE | `/api/patients/{id}` | Delete patient |

### Doctor Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/doctors` | Get all doctors (paginated) |
| GET | `/api/doctors/{id}` | Get doctor by ID |
| POST | `/api/doctors` | Create new doctor |
| PUT | `/api/doctors/{id}` | Update doctor |
| DELETE | `/api/doctors/{id}` | Delete doctor |

### Department Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/departments` | Get all departments (paginated) |
| GET | `/api/departments/{id}` | Get department by ID |
| POST | `/api/departments` | Create new department |
| PUT | `/api/departments/{id}` | Update department |
| DELETE | `/api/departments/{id}` | Delete department |

### Appointment Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/appointments` | Get all appointments (paginated) |
| GET | `/api/appointments/{id}` | Get appointment by ID |
| POST | `/api/appointments` | Create new appointment |
| PUT | `/api/appointments/{id}` | Update appointment |
| DELETE | `/api/appointments/{id}` | Cancel appointment |

### Prescription Endpoints
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/prescriptions` | Get all prescriptions (paginated) |
| GET | `/api/prescriptions/{id}` | Get prescription by ID |
| POST | `/api/prescriptions` | Create new prescription |
| PUT | `/api/prescriptions/{id}` | Update prescription |
| DELETE | `/api/prescriptions/{id}` | Delete prescription |

## Authentication

The API uses JWT (JSON Web Tokens) for authentication. To access protected endpoints:

1. Register a new user via `/api/auth/register`
2. Login via `/api/auth/login` to receive a JWT token
3. Include the token in the `Authorization` header of subsequent requests:
   ```
   Authorization: Bearer <your_jwt_token>
   ```

## Error Handling

The application implements global exception handling to provide consistent error responses across all endpoints. Error responses include:
- HTTP status code
- Error message
- Timestamp
- Request path (when applicable)

## Team Members

- **KvijoN** - Lead Developer
- **nikascontrolers** - Developer

## License

This project is proprietary and intended for educational purposes.

## Support

For issues, questions, or contributions, please contact the development team.

