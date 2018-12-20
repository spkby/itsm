package drugspayapplication.repository;

import drugspayapplication.entity.Patient;
import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, Long> {
}
