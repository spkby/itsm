package by.itsm.patients.logic.repository.domain;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.logic.repository.ICrudRepository;

public interface IPatientRepository extends ICrudRepository<Patient> {
    Patient findByPhone(String phone);
}
