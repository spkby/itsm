package by.itsm.patients.console.menu.patient;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.util.ConsoleFactory;
import by.itsm.patients.logic.service.domain.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@PatientMenuItem
public class PatientCreateMenuItem implements IMenuItem {

    @Autowired
    private ConsoleFactory<Patient> patientConsoleFactory;
    @Autowired
    private IPatientService patientService;

    @Override
    public String getTitle() {
        return "Add patient";
    }

    @Override
    public int doAction() {
        Patient patient = patientConsoleFactory.create();
        patientService.create(patient);
        return 0;
    }
}
