package by.itsm.patients.logic.service.domain.impl;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.logic.context.Auditable;
import by.itsm.patients.logic.exception.BusinessException;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.domain.ISaleRepository;
import by.itsm.patients.logic.service.AbstractCrudService;
import by.itsm.patients.logic.service.domain.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SaleService extends AbstractCrudService<Sale> implements ISaleService {

    @Autowired
    private ISaleRepository saleRepository;

    @Auditable
    @Override
    @Transactional
    public void update(Sale sale, Patient patient, Product product) {
        try {
            if (!product.getState().equals(patient.getState())) {
                throw new IllegalArgumentException("Patient and product state mismatch");
            }

            sale.setPatient(patient);
            sale.setProduct(product);

            saleRepository.update(sale);

        } catch (BusinessException e) {
            throw e;
        } catch (DatabaseException e) {
            throw e;
        }
    }

    @Auditable
    @Override
    @Transactional
    public void create(Patient patient, Product product) {
        try {
            if (!product.getState().equals(patient.getState())) {
                throw new IllegalArgumentException("Patient and product state mismatch");
            }

            Sale sale = new Sale(
                    LocalDateTime.now(),
                    patient,
                    product
            );

            saleRepository.create(sale);

        } catch (BusinessException e) {
            throw e;
        } catch (DatabaseException e) {
            throw e;
        }
    }

    @Override
    @Transactional
    public List<Sale> findByPatient(Patient patient) {
        try {
            return saleRepository.findByPatient(patient);
        } catch (DatabaseException e) {
            throw e;
        }
    }

}
