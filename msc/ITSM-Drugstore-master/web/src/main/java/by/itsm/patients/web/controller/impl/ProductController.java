package by.itsm.patients.web.controller.impl;

import by.itsm.patients.web.controller.AbstractCrudController;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.web.model.ProductDto;
import by.itsm.patients.web.service.ICrudService;
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
