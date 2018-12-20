package com.itsm.pub.courses.patients.web.controller.impl;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.web.controller.AbstractCrudController;
import com.itsm.pub.courses.patients.web.model.ProductDto;
import com.itsm.pub.courses.patients.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends AbstractCrudController<Product, ProductDto> {

    @Autowired
    public ProductController(ICrudService<Product, ProductDto> service) {
        super(service);
    }

}
