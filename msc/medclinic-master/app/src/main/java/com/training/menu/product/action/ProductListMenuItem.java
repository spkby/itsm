package com.training.menu.product.action;

import com.training.Product;
import com.training.menu.IMenuItem;
import com.training.menu.product.ProductMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import com.training.service.EntityListIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@ProductMenuItem
public class ProductListMenuItem implements IMenuItem {

    private final EntityListIdService<Product> productService;
    private final MenuHelper menuHelper;

    @Autowired
    public ProductListMenuItem(EntityCrudService<Product> productService, MenuHelper menuHelper) {
        this.productService = productService;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "List products";
    }

    @Override
    @Transactional
    public int doAction() {
        List<Product> products = productService.getAll();
        if (products.isEmpty()) {
            System.out.println("products not found");
        } else {
            products.forEach(System.out::println);
        }
        return 0;
    }

}
