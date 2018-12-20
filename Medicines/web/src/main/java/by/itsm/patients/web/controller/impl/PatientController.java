package by.itsm.patients.web.controller.impl;

import by.itsm.patients.web.controller.AbstractCrudController;
import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.web.model.PatientDto;
import by.itsm.patients.web.service.ICrudService;
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
