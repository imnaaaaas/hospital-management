package ge.ibsu.hospital.repositories;

import ge.ibsu.hospital.entities.Doctor;
import ge.ibsu.hospital.enums.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByDepartmentId(Long departmentId);
    List<Doctor> findBySpecialization(Specialization specialization);
}