package com.neuprakash.HospitalMgmtSystem.service.impl;

import com.neuprakash.HospitalMgmtSystem.dto.PatientDto;
import com.neuprakash.HospitalMgmtSystem.entity.Patient;
import com.neuprakash.HospitalMgmtSystem.repository.PatientRepository;
import com.neuprakash.HospitalMgmtSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;


    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtoList = patients.
                stream().map(patient -> new PatientDto(patient.getId(), patient.getFullName(), patient.getEmail(), patient.getContactNumber(), patient.getBirthDate()))
                .toList();

        return patientDtoList;
    }
}
