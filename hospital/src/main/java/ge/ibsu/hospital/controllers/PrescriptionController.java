package ge.ibsu.hospital.controllers;

import ge.ibsu.hospital.entities.Prescription;
import ge.ibsu.hospital.services.PrescriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/prescriptions")
public class PrescriptionController {
    private final PrescriptionService prescriptionService;

    @GetMapping
    public ResponseEntity<List<Prescription>> getAll() {
        return ResponseEntity.ok(prescriptionService.getAllPrescriptions());
    }

    @GetMapping("/patient/{patientId}")
    public ResponseEntity<List<Prescription>> getByPatient(@PathVariable Long patientId) {
        List<Prescription> prescriptions = prescriptionService.getAllByPatient(patientId);
        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<List<Prescription>> getByDoctor(@PathVariable Long doctorId) {
        List<Prescription> prescriptions = prescriptionService.getAllByDoctor(doctorId);
        return ResponseEntity.ok(prescriptions);
    }

    @PostMapping
    public ResponseEntity<Prescription> create(@RequestBody Prescription prescription) {
        Prescription created = prescriptionService.createPrescription(prescription);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (prescriptionService.deletePrescription(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

