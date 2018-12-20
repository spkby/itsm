package com.training.menu.product.action;

import com.training.Product;
import com.training.menu.IMenuItem;
import com.training.menu.product.ProductMenuItem;
import com.training.menu.util.ConsoleFactory;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@ProductMenuItem
public class ProductUpdateMenuItem implements IMenuItem {

    private final EntityCrudService<Product> productService;
    private final MenuHelper menuHelper;
    private final ConsoleFactory<Product> productConsoleFactory;

    @Autowired
    public ProductUpdateMenuItem(EntityCrudService<Product> productService, MenuHelper menuHelper, ConsoleFactory<Product> productConsoleFactory) {
        this.productService = productService;
        this.menuHelper = menuHelper;
        this.productConsoleFactory = productConsoleFactory;
    }


    @Override
    public String getTitle() {
        return "Update product";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter product id:");
        int id = menuHelper.readInt();
        Product product = productService.findById(id);
        if (product == null) {
            System.out.println("product not found");
            return 0;
        }else {
            System.out.println(product);
        }
        productConsoleFactory.update(product);
        productService.update(product);
        return 0;
    }

}
