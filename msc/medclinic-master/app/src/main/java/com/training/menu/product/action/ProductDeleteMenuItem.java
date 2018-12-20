package com.training.menu.product.action;

import com.training.Product;
import com.training.menu.IMenuItem;
import com.training.menu.product.ProductMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProductMenuItem
public class ProductDeleteMenuItem implements IMenuItem {

    private final EntityCrudService<Product> productEntityCrudService;
    private final MenuHelper menuHelper;

    @Autowired
    public ProductDeleteMenuItem(EntityCrudService<Product> productEntityCrudService, MenuHelper menuHelper) {
        this.productEntityCrudService = productEntityCrudService;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "Delete product";
    }

    @Override
    public int doAction() {
        System.out.println("Input product id:");
        int id = menuHelper.readInt();
        Product product = productEntityCrudService.findById(id);
        if (product == null) {
            System.out.println("product not found");
        } else {
            productEntityCrudService.delete(product);
        }
        return 0;
    }

    @Override
    public int priority() {
        return 2;
    }
}
