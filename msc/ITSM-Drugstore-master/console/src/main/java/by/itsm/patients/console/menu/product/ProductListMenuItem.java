package by.itsm.patients.console.menu.product;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.logic.service.IListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@ProductMenuItem
public class ProductListMenuItem implements IMenuItem {

    @Autowired
    private IListService<Product> productService;

    @Override
    public String getTitle() {
        return "Print product list";
    }

    @Override
    @Transactional
    public int doAction() {
        productService.findAll().forEach(System.out::println);
        return 0;
    }
}
