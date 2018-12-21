package by.itsm.patients.console.menu.sale;

import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.IPatientService;
import by.itsm.patients.logic.service.domain.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SaleConsoleFactory {

    @Autowired
    private MenuHelper helper;
    @Autowired
    private IProductService productService;
    @Autowired
    private IPatientService patientService;

    @Transactional
    public Patient getPatientByPhone() {

        System.out.println("input patient phone: ");
        String phone = helper.read();

        return patientService.findByPhone(phone);
    }

    @Transactional
    public Product getProductByName() {

        System.out.println("input product name");
        String name = helper.read();

        return productService.getByProductName(name);
    }
}
