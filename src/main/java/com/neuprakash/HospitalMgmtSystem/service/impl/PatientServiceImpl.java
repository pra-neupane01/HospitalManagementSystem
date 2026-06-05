package com.neuprakash.HospitalMgmtSystem.service.impl;

import com.neuprakash.HospitalMgmtSystem.dto.AddPatientDto;
import com.neuprakash.HospitalMgmtSystem.dto.PatientDto;
import com.neuprakash.HospitalMgmtSystem.entity.Patient;
import com.neuprakash.HospitalMgmtSystem.repository.PatientRepository;
import com.neuprakash.HospitalMgmtSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientDto> patientDtoList = patients.
                stream().map(patient -> new PatientDto(patient.getId(), patient.getFullName(), patient.getEmail(), patient.getContactNumber(), patient.getBirthDate()))
                .toList();

        return patientDtoList;
    }

    @Override
    public PatientDto getPatientById(Long id) {
         Patient patient = patientRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Patient not found.."));
         return  modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public PatientDto createPatient(AddPatientDto addPatientDto) {
        Patient newPatient = modelMapper.map(addPatientDto, Patient.class);
        Patient patient = patientRepository.save(newPatient);
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public void deletePatientById(Long id) {
        if(!patientRepository.existsById(id)){
            throw new IllegalArgumentException("Student does not exists");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public PatientDto updatePatient(Long id, AddPatientDto addPatientDto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow( ()-> new IllegalArgumentException("Patient Not found."));
        modelMapper.map(addPatientDto, patient);

        patientRepository.save(patient);
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public PatientDto updatePartialPatient(Long id, Map<String, Object> updates) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow( ()-> new IllegalArgumentException("Patient Not found."));
        updates.forEach((String field, Object value) -> {
            switch (field){
                case "name":patient.setFullName((String) value);
                break;
                case "email":patient.setEmail((String) value);
                break;
                default:
                    throw new IllegalArgumentException("Filed is not supported");
            }
        });
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDto.class);
    }
}



























