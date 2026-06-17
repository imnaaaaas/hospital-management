package ge.ibsu.hospital.services;

import ge.ibsu.hospital.entities.Department;
import ge.ibsu.hospital.repositories.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> updateDepartment(Long id, Department department) {
        return departmentRepository.findById(id)
                .map(existingDepartment -> {
                    if (department.getName() != null) {
                        existingDepartment.setName(department.getName());
                    }
                    if (department.getDescription() != null) {
                        existingDepartment.setDescription(department.getDescription());
                    }
                    return departmentRepository.save(existingDepartment);
                });
    }

    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}