package by.itsm.patients.console.menu.patient;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.State;
import by.itsm.patients.console.menu.util.ConsoleFactory;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PatientConsoleFactory implements ConsoleFactory<Patient> {

    @Autowired
    private IStateService stateService;
    @Autowired
    private MenuHelper helper;

    @Override
    public Patient create() {
        Patient patient = new Patient();
        update(patient);
        return patient;
    }

    @Transactional
    @Override
    public void update(Patient patient) {
        System.out.println("Input phone:");
        String phone = helper.read();

        System.out.println("Input state code");
        String stateCode = helper.read();

        State state = stateService.findByCode(stateCode);

        patient.setPhone(phone);
        patient.setState(state);
    }
}
