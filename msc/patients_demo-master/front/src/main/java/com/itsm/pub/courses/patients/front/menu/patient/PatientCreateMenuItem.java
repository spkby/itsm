package com.itsm.pub.courses.patients.front.menu.patient;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.menu.util.ConsoleFactory;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@PatientMenuItem
public class PatientCreateMenuItem implements IMenuItem {

    private final ConsoleFactory<Patient> patientConsoleFactory;
    private final ICrudRepository<Patient> patientRepository;

    @Autowired
    public PatientCreateMenuItem(
            ConsoleFactory<Patient> patientConsoleFactory,
            ICrudRepository<Patient> patientRepository) {
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
