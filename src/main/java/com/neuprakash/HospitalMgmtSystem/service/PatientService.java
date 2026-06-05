package com.neuprakash.HospitalMgmtSystem.service;

import com.neuprakash.HospitalMgmtSystem.dto.AddPatientDto;
import com.neuprakash.HospitalMgmtSystem.dto.PatientDto;



import java.util.List;
import java.util.Map;

public interface PatientService {

    List<PatientDto> getAllPatients();

    PatientDto getPatientById(Long id);

    PatientDto createPatient(AddPatientDto addPatientDto);

    void deletePatientById( Long id);

    PatientDto updatePatient(Long id, AddPatientDto addPatientDto);

    PatientDto updatePartialPatient(Long id, Map<String, Object> updates);
}
