package by.itsm.patients.console.menu.product;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.patient.PatientMenuItem;
import by.itsm.patients.console.menu.util.ConsoleFactory;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@ProductMenuItem
public class ProductUpdateMenuItem implements IMenuItem {

    @Autowired
    private ConsoleFactory<Product> productConsoleFactory;
    @Autowired
    private IProductService productService;
    @Autowired
    private MenuHelper menuHelper;

    @Override
    public String getTitle() {
        return "Update product";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter product id:");
        int id = menuHelper.readInt();
        Product product = productService.findBy(id);
        if (product == null) {
            System.out.println("product not found");
            return 0;
        } else {
            System.out.println(product);
        }
        productConsoleFactory.update(product);
        productService.update(product);
        return 0;
    }
}
