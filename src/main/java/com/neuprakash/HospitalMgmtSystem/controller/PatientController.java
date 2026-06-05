package com.neuprakash.HospitalMgmtSystem.controller;

import com.neuprakash.HospitalMgmtSystem.dto.AddPatientDto;
import com.neuprakash.HospitalMgmtSystem.dto.PatientDto;
import com.neuprakash.HospitalMgmtSystem.entity.Patient;
import com.neuprakash.HospitalMgmtSystem.repository.PatientRepository;
import com.neuprakash.HospitalMgmtSystem.service.PatientService;
import com.neuprakash.HospitalMgmtSystem.service.impl.PatientServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<PatientDto> createPatient(@RequestBody AddPatientDto addPatientDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createPatient(addPatientDto));




    }
}






















