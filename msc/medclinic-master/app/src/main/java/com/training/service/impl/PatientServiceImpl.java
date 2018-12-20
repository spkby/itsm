package com.training.service.impl;

import com.training.dto.PatientFindByPhoneDao;
import com.training.Patient;
import com.training.service.PatientFindByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl extends AbstractServiceIml<Patient> implements PatientFindByNameService {

    private final PatientFindByPhoneDao findByPhoneDao;

    @Autowired
    public PatientServiceImpl(PatientFindByPhoneDao findByPhoneDao) {
        this.findByPhoneDao = findByPhoneDao;
    }

    @Override
    public Patient findByName(String phone) {
        return findByPhoneDao.findByPhone(phone);
    }
}
