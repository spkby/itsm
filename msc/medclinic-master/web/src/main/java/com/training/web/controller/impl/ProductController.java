package com.training.web.controller.impl;

import com.training.Product;
import com.training.web.controller.AbstractCrudController;
import com.training.web.model.ProductIDto;
import com.training.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractCrudController<Product, ProductIDto> {

    @Autowired
    public ProductController(ICrudService<Product, ProductIDto> service) {
        super(service);
    }
}
