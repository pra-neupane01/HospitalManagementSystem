package com.neuprakash.HospitalMgmtSystem.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddPatientDto {
    @NotBlank(message = "Name is required")
    private String fullName;

    @Email
    @NotBlank(message = "Email is Required")
    private String email;

    @Size(min = 10, max = 14, message = "Provide valid Contact number")
    private String contactNumber;

    private LocalDate birthDate;


}
