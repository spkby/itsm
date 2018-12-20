package by.itsm.patients.logic.repository.domain.impl;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.AbstractCrudRepository;
import by.itsm.patients.logic.repository.domain.IPatientRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class PatientRepository extends AbstractCrudRepository<Patient>
        implements IPatientRepository {

    public PatientRepository() {
        typeClass = Patient.class;
    }

    @Override
    @Transactional
    public Patient findByPhone(String phone) {
        try {
            TypedQuery<Patient> query = em.createQuery("select p from patient p where p.phone = :phone", Patient.class);
            query.setParameter("phone", phone);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (DatabaseException e) {
            throw e;
        }
    }
}
