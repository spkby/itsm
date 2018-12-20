package com.itsm.pub.courses.patients.web.service.impl;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.web.model.PatientDto;
import com.itsm.pub.courses.patients.web.service.AbstractCrudService;
import com.itsm.pub.courses.patients.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PatientService extends AbstractCrudService<Patient, PatientDto> {

    @Autowired
    public PatientService(
            JpaRepository<Patient, Integer> repository,
            Converter<Patient, PatientDto> converter
    ) {
        super(repository, converter);
    }
}
