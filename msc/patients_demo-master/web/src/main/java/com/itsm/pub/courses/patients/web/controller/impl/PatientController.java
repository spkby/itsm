package com.itsm.pub.courses.patients.web.controller.impl;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.web.controller.AbstractCrudController;
import com.itsm.pub.courses.patients.web.model.PatientDto;
import com.itsm.pub.courses.patients.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController extends AbstractCrudController<Patient, PatientDto> {

    @Autowired
    public PatientController(ICrudService<Patient, PatientDto> service) {
        super(service);
    }

}
