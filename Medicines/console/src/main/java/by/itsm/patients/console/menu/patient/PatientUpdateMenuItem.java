package by.itsm.patients.console.menu.patient;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.util.ConsoleFactory;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientUpdateMenuItem implements IMenuItem {

    @Autowired
    private ConsoleFactory<Patient> patientConsoleFactory;
    @Autowired
    private IPatientService patientService;
    @Autowired
    private MenuHelper menuHelper;

    @Override
    public String getTitle() {
        return "Update patient";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter patient id:");
        int id = menuHelper.readInt();
        Patient patient = patientService.findBy(id);
        if (patient == null) {
            System.out.println("patient not found");
            return 0;
        } else {
            System.out.println(patient);
        }
        patientConsoleFactory.update(patient);
        patientService.update(patient);
        return 0;
    }
}
