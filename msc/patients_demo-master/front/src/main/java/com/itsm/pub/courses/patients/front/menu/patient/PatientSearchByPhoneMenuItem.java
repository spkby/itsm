package com.itsm.pub.courses.patients.front.menu.patient;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.menu.util.MenuHelper;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientSearchByPhoneMenuItem implements IMenuItem {

    private final IPatientRepository patientRepository;
    private final MenuHelper menuHelper;

    @Autowired
    public PatientSearchByPhoneMenuItem(IPatientRepository patientRepository, MenuHelper menuHelper) {
        this.patientRepository = patientRepository;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "Search by phone";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter patient phone:");
        String phone = menuHelper.read();
        Patient patient = patientRepository.findByPhone(phone);
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
