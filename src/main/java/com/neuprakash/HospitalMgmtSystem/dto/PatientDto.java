package com.neuprakash.HospitalMgmtSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class PatientDto {
    private Long id;
    private String fullName;
    private String email;
    private String contactNumber;
    private LocalDate birthDate;


}
