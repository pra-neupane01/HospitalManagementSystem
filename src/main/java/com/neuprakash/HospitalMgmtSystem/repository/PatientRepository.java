package com.neuprakash.HospitalMgmtSystem.repository;

import com.neuprakash.HospitalMgmtSystem.entity.Patient;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {


}
