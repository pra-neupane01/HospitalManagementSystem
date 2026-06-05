package com.neuprakash.HospitalMgmtSystem.service;

import com.neuprakash.HospitalMgmtSystem.dto.AddPatientDto;
import com.neuprakash.HospitalMgmtSystem.dto.PatientDto;



import java.util.List;

public interface PatientService {

    List<PatientDto> getAllPatients();

    PatientDto getPatientById(Long id);

    PatientDto createPatient(AddPatientDto addPatientDto);
}
