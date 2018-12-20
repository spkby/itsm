package com.training.menu.patient.action;

import com.training.Patient;
import com.training.menu.IMenuItem;
import com.training.menu.patient.PatientMenuItem;
import com.training.menu.util.ConsoleFactory;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientUpdateMenuItem implements IMenuItem {

    private final EntityCrudService<Patient> patientService;
    private final MenuHelper menuHelper;
    private final ConsoleFactory<Patient> patientConsoleFactory;

    @Autowired
    public PatientUpdateMenuItem(EntityCrudService<Patient> patientService, MenuHelper menuHelper, ConsoleFactory<Patient> patientConsoleFactory) {
        this.patientService = patientService;
        this.menuHelper = menuHelper;
        this.patientConsoleFactory = patientConsoleFactory;
    }

    @Override
    public String getTitle() {
        return "Update patient";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter patient id:");
        int id = menuHelper.readInt();
        Patient patient = patientService.findById(id);
        if (patient == null) {
            System.out.println("patient not found");
            return 0;
        }else {
            System.out.println(patient);
        }
        patientConsoleFactory.update(patient);
        patientService.update(patient);
        return 0;
    }

}
