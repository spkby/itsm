package com.itsm.pub.courses.patients.web.controller.impl;

import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.web.controller.AbstractCrudController;
import com.itsm.pub.courses.patients.web.model.ProductSaleDto;
import com.itsm.pub.courses.patients.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/product_sale")
public class ProductSaleController extends AbstractCrudController<ProductSale, ProductSaleDto> {

    @Autowired
    public ProductSaleController(ICrudService<ProductSale, ProductSaleDto> service) {
        super(service);
    }
}
