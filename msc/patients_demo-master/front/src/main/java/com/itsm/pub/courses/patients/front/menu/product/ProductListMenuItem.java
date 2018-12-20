package com.itsm.pub.courses.patients.front.menu.product;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.menu.state.StateMenuItem;
import com.itsm.pub.courses.patients.front.repository.IListRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@ProductMenuItem
public class ProductListMenuItem implements IMenuItem {

    private final IListRepository<Product> productRepository;

    public ProductListMenuItem(IListRepository<Product> productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public String getTitle() {
        return "Print product list";
    }

    @Override
    @Transactional
    public int doAction() {
        productRepository.findAll().forEach(System.out::println);
        return 0;
    }
}
