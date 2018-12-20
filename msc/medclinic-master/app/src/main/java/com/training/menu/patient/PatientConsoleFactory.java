package com.training.menu.patient;

import com.training.Patient;
import com.training.State;
import com.training.menu.util.ConsoleFactory;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientConsoleFactory implements ConsoleFactory<Patient> {

    private final MenuHelper helper;
    private final EntityCrudService<State> stateService;

    @Autowired
    public PatientConsoleFactory(MenuHelper helper, EntityCrudService<State> stateService) {
        this.helper = helper;
        this.stateService = stateService;
    }

    @Override
    public Patient create() {
        Patient patient = new Patient();
        update(patient);
        return patient;
    }

    @Override
    public void update(Patient patient) {
        System.out.println("Enter phone number: ");
        String phone = helper.read();
        patient.setPhone(phone);

        System.out.println("Enter number State: ");
        printAllState();

        int stateNumber = helper.readInt();
        State state = stateService.findById(stateNumber);
        patient.setState_id(state);
    }

    private void printAllState() {
        List<State> states = stateService.getAll();
        for (int i = 0; i < states.size(); i++) {
            System.out.println((i + 1) + " " + states.get(i).getName());
        }
    }
}
