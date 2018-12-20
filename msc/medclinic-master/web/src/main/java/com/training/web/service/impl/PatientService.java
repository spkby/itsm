package com.training.web.service.impl;

import com.training.Patient;
import com.training.web.model.PatientIDto;
import com.training.web.service.AbstractCrudService;
import com.training.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;

@Service
@Transactional
public class PatientService extends AbstractCrudService<Patient, PatientIDto> {

    @Autowired
    public PatientService(JpaRepository<Patient, Integer> repository, Converter<Patient, PatientIDto> converter) {
        super(repository, converter);
    }
}
