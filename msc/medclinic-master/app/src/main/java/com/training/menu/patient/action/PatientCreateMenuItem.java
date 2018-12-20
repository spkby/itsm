package com.training.menu.patient.action;

import com.training.Patient;
import com.training.menu.IMenuItem;
import com.training.menu.patient.PatientMenuItem;
import com.training.menu.util.ConsoleFactory;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@PatientMenuItem
public class PatientCreateMenuItem implements IMenuItem {

    private final ConsoleFactory<Patient> patientConsoleFactory;
    private final EntityCrudService<Patient> patientRepository;

    @Autowired
    public PatientCreateMenuItem(ConsoleFactory<Patient> patientConsoleFactory, EntityCrudService<Patient> patientRepository) {
        this.patientConsoleFactory = patientConsoleFactory;
        this.patientRepository = patientRepository;
    }

    @Override
    public String getTitle() {
        return "Add patient";
    }

    @Override
    public int doAction() {
        Patient patient = patientConsoleFactory.create();
        patientRepository.create(patient);
        return 0;
    }
}
