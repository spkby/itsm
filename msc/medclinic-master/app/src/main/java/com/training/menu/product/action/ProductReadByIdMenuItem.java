package com.training.menu.product.action;

import com.training.Product;
import com.training.menu.IMenuItem;
import com.training.menu.product.ProductMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@ProductMenuItem
public class ProductReadByIdMenuItem implements IMenuItem {

    private final EntityCrudService<Product> productService;
    private final MenuHelper menuHelper;

    @Autowired
    public ProductReadByIdMenuItem(EntityCrudService<Product> productService, MenuHelper menuHelper) {
        this.productService = productService;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "Reade by id";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter product id:");
        int id = menuHelper.readInt();
        Product product = productService.findById(id);
        if (product == null) {
            System.out.println("product not found");
        } else {
            System.out.println(product);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 3;
    }
}
