package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.front.repository.AbstractCrudRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IPatientRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class PatientRepository extends AbstractCrudRepository<Patient>
        implements IPatientRepository {

    @Override
    protected Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Patient findByPhone(String phone) {
        TypedQuery<Patient> query = em.createQuery("select p from patient p where p.phone = :phone", Patient.class);
        query.setParameter("phone", phone);
        return query.getSingleResult();
    }
}
