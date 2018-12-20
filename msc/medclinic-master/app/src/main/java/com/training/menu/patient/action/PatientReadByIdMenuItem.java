package com.training.menu.patient.action;

import com.training.Patient;
import com.training.menu.IMenuItem;
import com.training.menu.patient.PatientMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientReadByIdMenuItem implements IMenuItem {

    private final EntityCrudService<Patient> patientService;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientReadByIdMenuItem(EntityCrudService<Patient> patientService, MenuHelper menuHelper) {
        this.patientService = patientService;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "Reade by id";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter patient id:");
        int id = menuHelper.readInt();
        Patient patient = patientService.findById(id);
        if (patient == null) {
            System.out.println("patient not found");
        } else {
            System.out.println(patient);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 3;
    }
}
