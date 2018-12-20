package com.training.menu.product.action;

import com.training.Product;
import com.training.menu.IMenuItem;
import com.training.menu.product.ProductMenuItem;
import com.training.menu.util.ConsoleFactory;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProductMenuItem
public class ProductCreateMenuItem implements IMenuItem {

    private final ConsoleFactory<Product> productConsoleFactory;
    private final EntityCrudService<Product> productEntityCrudService;

    @Autowired
    public ProductCreateMenuItem(ConsoleFactory<Product> productConsoleFactory, EntityCrudService<Product> productEntityCrudService) {
        this.productConsoleFactory = productConsoleFactory;
        this.productEntityCrudService = productEntityCrudService;
    }
    @Override
    public String getTitle() {
        return "Add product";
    }

    @Override
    public int doAction() {
        Product product = productConsoleFactory.create();
        productEntityCrudService.create(product);
        return 0;
    }
}
