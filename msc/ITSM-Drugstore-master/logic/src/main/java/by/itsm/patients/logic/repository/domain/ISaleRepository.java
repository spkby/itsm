package by.itsm.patients.logic.repository.domain;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.logic.repository.ICrudRepository;

import java.util.List;

public interface ISaleRepository extends ICrudRepository<Sale> {

    void sale(Product product, Patient patient);

    List<Sale> findByPatient(Patient patient);
}
