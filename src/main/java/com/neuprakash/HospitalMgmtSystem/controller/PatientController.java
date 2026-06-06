package com.neuprakash.HospitalMgmtSystem.controller;

import com.neuprakash.HospitalMgmtSystem.dto.AddPatientDto;
import com.neuprakash.HospitalMgmtSystem.dto.PatientDto;
import com.neuprakash.HospitalMgmtSystem.entity.Patient;
import com.neuprakash.HospitalMgmtSystem.repository.PatientRepository;
import com.neuprakash.HospitalMgmtSystem.service.PatientService;
import com.neuprakash.HospitalMgmtSystem.service.impl.PatientServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class PatientController {
    @Autowired
    private final PatientService patientService;

    @GetMapping("/patient")
    public ResponseEntity<List<PatientDto>> getPatient() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    @GetMapping("/patient/{id}")
    public PatientDto getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @PostMapping("/create-patient")
    public ResponseEntity<PatientDto> createPatient(@RequestBody @Valid AddPatientDto addPatientDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatient(addPatientDto));
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        patientService.deletePatientById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("patient/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id,
                                                    @RequestBody AddPatientDto addPatientDto){
        return ResponseEntity.ok(patientService.updatePatient(id, addPatientDto));
    }

    @PatchMapping("patient/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id,
                                                    @RequestBody Map<String, Object> updates){
        return ResponseEntity.ok(patientService.updatePartialPatient(id, updates));
    }


}





















