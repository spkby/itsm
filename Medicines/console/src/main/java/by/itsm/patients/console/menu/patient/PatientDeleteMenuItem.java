package by.itsm.patients.console.menu.patient;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientDeleteMenuItem implements IMenuItem {

    @Autowired
    private IPatientService patientService;
    @Autowired
    private MenuHelper menuHelper;

    @Override
    public String getTitle() {
        return "Delete patient";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Input patient id:");
        int id = menuHelper.readInt();
        Patient patient = patientService.findBy(id);
        if (patient == null) {
            System.out.println("patient not found");
        } else {
            patientService.delete(patient);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 2;
    }
}
