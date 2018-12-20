package com.itsm.pub.courses.patients.front.menu.patient;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.menu.util.ConsoleFactory;
import com.itsm.pub.courses.patients.front.menu.util.MenuHelper;
import com.itsm.pub.courses.patients.front.repository.domain.impl.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatientConsoleFactory implements ConsoleFactory<Patient> {

    private final MenuHelper helper;
    private final StateRepository stateRepository;



    @Autowired
    public PatientConsoleFactory(
            MenuHelper helper,
            StateRepository stateRepository) {
        this.helper = helper;
        this.stateRepository = stateRepository;
    }

    @Override
    public Patient create() {
        Patient patient = new Patient();
        update(patient);
        return patient;
    }

    @Override
    public void update(Patient patient) {
        System.out.println("Input phone:");
        String phone = helper.read();


        System.out.println("Input state code");
        String stateCode = helper.read();

        State state = stateRepository.findByCode(stateCode);

        patient.setPhone(phone);
        patient.setState(state);
    }
}
