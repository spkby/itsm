package com.itsm.pub.courses.patients.front.repository.domain;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;

public interface IPatientRepository extends ICrudRepository<Patient> {
    Patient findByPhone(String phone);
}
