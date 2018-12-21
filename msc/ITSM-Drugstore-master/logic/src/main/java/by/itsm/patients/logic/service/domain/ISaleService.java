package by.itsm.patients.logic.service.domain;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.logic.service.ICrudService;

import java.util.List;

public interface ISaleService extends ICrudService<Sale> {

//    Sale getNew(Patient patient, Product product);
//
//    Sale getExist(Integer id);

    void update(Sale sale, Patient patient, Product product);

    void create(Patient patient, Product product);

    List<Sale> findByPatient(Patient patient);

}
