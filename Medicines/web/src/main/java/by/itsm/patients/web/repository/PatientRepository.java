package by.itsm.patients.web.repository;

import by.itsm.patients.common.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}
