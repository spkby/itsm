package by.itsm.patients.console.menu.sale;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.logic.service.domain.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleCreateMenuItem implements IMenuItem {

    @Autowired
    private ISaleService saleService;
    @Autowired
    private SaleConsoleFactory factory;

    @Override
    public String getTitle() {
        return "Make sale";
    }

    @Override
    @Transactional
    public int doAction() {

        Patient patient = factory.getPatientByPhone();
        Product product = factory.getProductByName();

        try {
            saleService.create(patient, product);
        } catch (Exception e) {
            System.out.println("failed to complete sale: " + e.getMessage());
        }

        return 0;
    }
}
