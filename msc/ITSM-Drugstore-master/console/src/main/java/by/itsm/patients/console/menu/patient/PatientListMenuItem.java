package by.itsm.patients.console.menu.patient;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.product.ProductMenuItem;
import by.itsm.patients.logic.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@PatientMenuItem
public class PatientListMenuItem implements IMenuItem {

    @Autowired
    private IListService<Patient> patientService;

    @Override
    public String getTitle() {
        return "Print patient list";
    }

    @Override
    @Transactional
    public int doAction() {
        patientService.findAll().forEach(System.out::println);
        return 0;
    }
}
