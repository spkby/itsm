package com.training.web.controller.impl;

import com.training.Patient;
import com.training.web.controller.AbstractCrudController;
import com.training.web.model.PatientIDto;
import com.training.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController extends AbstractCrudController<Patient, PatientIDto> {

    @Autowired
    public PatientController(ICrudService<Patient, PatientIDto> service) {
        super(service);
    }
}
