package com.training.menu.product.action;

import com.training.Product;
import com.training.menu.IMenuItem;
import com.training.menu.product.ProductMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.ProductFindByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@ProductMenuItem
public class ProductFindByNameMenuItem implements IMenuItem {

    private final ProductFindByNameService productService;
    private final MenuHelper menuHelper;

    @Autowired
    public ProductFindByNameMenuItem(ProductFindByNameService productService, MenuHelper menuHelper) {
        this.productService = productService;
        this.menuHelper = menuHelper;
    }

    @Override
    public String getTitle() {
        return "Find product by name";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("Enter product name:");
        String name = menuHelper.read();
        Product product = productService.findByName(name);
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
