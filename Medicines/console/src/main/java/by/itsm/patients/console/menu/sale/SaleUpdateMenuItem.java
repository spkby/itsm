package by.itsm.patients.console.menu.sale;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleUpdateMenuItem implements IMenuItem {

    @Autowired
    private ISaleService saleService;
    @Autowired
    private MenuHelper helper;
    @Autowired
    private SaleConsoleFactory factory;

    @Override
    public String getTitle() {
        return "Update sale";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter sale id:");
        int id = helper.readInt();
        Sale oldSale = saleService.findBy(id);
        if (oldSale == null) {
            System.out.println("sale not found");
        }

        Patient patient = factory.getPatientByPhone();
        if (patient == null) {
            System.out.println("Patient not found");
            return 0;
        }

        Product product = factory.getProductByName();
        if (product == null) {
            System.out.println("product not found");
            return 0;
        }

        try {
            saleService.update(oldSale, patient, product);
        } catch (Exception e) {
            System.out.println("failed to complete sale: " + e.getMessage());
//            e.printStackTrace();
            return 0;
        }

        return 0;
    }

    @Override
    public int priority() {
        return 3;
    }
}
