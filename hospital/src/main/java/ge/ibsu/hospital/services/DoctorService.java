package ge.ibsu.hospital.services;

import ge.ibsu.hospital.entities.Doctor;
import ge.ibsu.hospital.repositories.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public List<Doctor> getDoctorsByDepartment(Long departmentId) {
        return doctorRepository.findByDepartmentId(departmentId);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<Doctor> updateDoctor(Long id, Doctor doctor) {
        return doctorRepository.findById(id)
                .map(existingDoctor -> {
                    if (doctor.getFirstName() != null) {
                        existingDoctor.setFirstName(doctor.getFirstName());
                    }
                    if (doctor.getLastName() != null) {
                        existingDoctor.setLastName(doctor.getLastName());
                    }
                    if (doctor.getEmail() != null) {
                        existingDoctor.setEmail(doctor.getEmail());
                    }
                    if (doctor.getPhoneNumber() != null) {
                        existingDoctor.setPhoneNumber(doctor.getPhoneNumber());
                    }
                    if (doctor.getSpecialization() != null) {
                        existingDoctor.setSpecialization(doctor.getSpecialization());
                    }
                    if (doctor.getDepartment() != null) {
                        existingDoctor.setDepartment(doctor.getDepartment());
                    }
                    return doctorRepository.save(existingDoctor);
                });
    }

    public boolean deleteDoctor(Long id) {
        if (doctorRepository.existsById(id)) {
            doctorRepository.deleteById(id);
            return true;
        }
        return false;
    }
}