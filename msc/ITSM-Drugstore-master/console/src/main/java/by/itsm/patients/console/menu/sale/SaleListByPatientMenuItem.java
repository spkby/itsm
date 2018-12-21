package by.itsm.patients.console.menu.sale;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.logic.service.domain.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleListByPatientMenuItem implements IMenuItem {

    @Autowired
    private ISaleService saleService;

    @Autowired
    private SaleConsoleFactory factory;

    @Override
    public String getTitle() {
        return "Print all sales by patient";
    }

    @Override
    @Transactional
    public int doAction() {

        Patient patient = factory.getPatientByPhone();

        saleService.findByPatient(patient).forEach(System.out::println);
        return 0;
    }
}
