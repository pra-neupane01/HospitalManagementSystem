package com.neuprakash.HospitalMgmtSystem.dto;


import lombok.Data;

import java.time.LocalDate;

@Data
public class AddPatientDto {
    private String fullName;
    private String email;
    private String contactNumber;
    private LocalDate birthDate;


}
