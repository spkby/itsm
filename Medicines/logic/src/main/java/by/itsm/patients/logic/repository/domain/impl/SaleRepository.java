package by.itsm.patients.logic.repository.domain.impl;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.common.entity.State;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.AbstractCrudRepository;
import by.itsm.patients.logic.repository.domain.ISaleRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class SaleRepository extends AbstractCrudRepository<Sale> implements ISaleRepository {

    public SaleRepository() {
        typeClass = Sale.class;
    }

    @Override
    @Transactional
    public void sale(Product product, Patient patient) {
        if (!product.getState().equals(patient.getState())) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        Sale sale = new Sale(
                LocalDateTime.now(),
                patient,
                product
        );

        em.persist(sale);
    }

    @Override
    @Transactional
    public List<Sale> findByPatient(Patient patient) {
        try {
            TypedQuery<Sale> query = em.createQuery("select s from sale s where s.patient = :patient", Sale.class);
            query.setParameter("patient", patient);
            List<Sale> resultList = query.getResultList();
            return resultList;
        } catch (DatabaseException e) {
            throw e;
        }
    }
}
