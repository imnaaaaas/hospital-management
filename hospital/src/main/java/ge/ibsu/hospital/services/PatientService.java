package ge.ibsu.hospital.services;

import ge.ibsu.hospital.entities.Patient;
import ge.ibsu.hospital.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(Long id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Optional<Patient> updatePatient(Long id, Patient patient) {
        return patientRepository.findById(id)
                .map(existingPatient -> {
                    if (patient.getFirstName() != null) {
                        existingPatient.setFirstName(patient.getFirstName());
                    }
                    if (patient.getLastName() != null) {
                        existingPatient.setLastName(patient.getLastName());
                    }
                    if (patient.getEmail() != null) {
                        existingPatient.setEmail(patient.getEmail());
                    }
                    if (patient.getPhoneNumber() != null) {
                        existingPatient.setPhoneNumber(patient.getPhoneNumber());
                    }
                    if (patient.getDateOfBirth() != null) {
                        existingPatient.setDateOfBirth(patient.getDateOfBirth());
                    }
                    if (patient.getGender() != null) {
                        existingPatient.setGender(patient.getGender());
                    }
                    if (patient.getBloodType() != null) {
                        existingPatient.setBloodType(patient.getBloodType());
                    }
                    if (patient.getAddress() != null) {
                        existingPatient.setAddress(patient.getAddress());
                    }
                    return patientRepository.save(existingPatient);
                });
    }

    public boolean deletePatient(Long id) {
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return true;
        }
        return false;
    }
}