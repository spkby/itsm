package com.itsm.pub.courses.patients.web.repository;

import com.itsm.pub.courses.patients.common.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
