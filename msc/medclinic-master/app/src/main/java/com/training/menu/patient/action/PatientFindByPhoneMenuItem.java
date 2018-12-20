package com.training.menu.patient.action;

import com.training.Patient;
import com.training.menu.IMenuItem;
import com.training.menu.patient.PatientMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.PatientFindByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientFindByPhoneMenuItem implements IMenuItem {

    private final PatientFindByNameService patientService;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientFindByPhoneMenuItem(PatientFindByNameService patientService, MenuHelper menuHelper) {
        this.patientService = patientService;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "Find patient by phone";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter patient phone:");
        String phone = menuHelper.read();
        Patient patient = patientService.findByName(phone);
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
