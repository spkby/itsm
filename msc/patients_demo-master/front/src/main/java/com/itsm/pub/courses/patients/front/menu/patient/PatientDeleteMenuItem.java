package com.itsm.pub.courses.patients.front.menu.patient;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.menu.util.MenuHelper;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientDeleteMenuItem implements IMenuItem {

    private final ICrudRepository<Patient> patientRepository;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientDeleteMenuItem(ICrudRepository<Patient> patientRepository, MenuHelper menuHelper) {
        this.patientRepository = patientRepository;
        this.menuHelper = menuHelper;
    }


    @Override
    public String getTitle() {
        return "Delete patient";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Input patient id:");
        int id = menuHelper.readInt();
        Patient patient = patientRepository.find(id);
        if (patient == null) {
            System.out.println("patient not found");
        } else {
            patientRepository.delete(patient);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 2;
    }
}
