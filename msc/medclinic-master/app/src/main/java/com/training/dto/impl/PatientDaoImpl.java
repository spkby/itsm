package com.training.dto.impl;

import com.training.dto.PatientFindByPhoneDao;
import com.training.Patient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class PatientDaoImpl extends AbstractDaoImpl<Patient> implements PatientFindByPhoneDao {

    private final static Logger logger = LogManager.getLogger(PatientDaoImpl.class);

    @Override
    protected Class<Patient> getEntityClass() {
        return Patient.class;
    }

    @Override
    public Patient findByPhone(String phone) {
        logger.info("Finding phone with name: " + phone);
        TypedQuery<Patient> query = em.createQuery("select p from patients p where p.phone = :phone", getEntityClass());
        query.setParameter("phone", phone);
        return query.getSingleResult();
    }
}
