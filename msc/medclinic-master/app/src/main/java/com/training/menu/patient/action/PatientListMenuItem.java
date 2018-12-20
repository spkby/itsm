package com.training.menu.patient.action;

import com.training.Patient;
import com.training.menu.IMenuItem;
import com.training.menu.patient.PatientMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import com.training.service.EntityListIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@PatientMenuItem
public class PatientListMenuItem implements IMenuItem {

    private final EntityListIdService<Patient> patientService;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientListMenuItem(EntityCrudService<Patient> patientService, MenuHelper menuHelper) {
        this.patientService = patientService;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "List patients";
    }

    @Override
    @Transactional
    public int doAction() {
        List<Patient> patients = patientService.getAll();
        if (patients.isEmpty()) {
            System.out.println("patients not found");
        } else {
            patients.forEach(System.out::println);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 3;
    }
}
