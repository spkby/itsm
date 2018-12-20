package by.itsm.patients.console.menu.product;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.util.ConsoleFactory;
import by.itsm.patients.logic.service.domain.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProductMenuItem
public class ProductCreateMenuItem implements IMenuItem {

    @Autowired
    private ConsoleFactory<Product> productConsoleFactory;
    @Autowired
    private IProductService productService;

    @Override
    public String getTitle() {
        return "Add product";
    }

    @Override
    public int doAction() {
        Product product = productConsoleFactory.create();
        productService.create(product);
        return 0;
    }
}
