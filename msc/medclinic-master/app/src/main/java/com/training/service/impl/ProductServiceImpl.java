package com.training.service.impl;

import com.training.dto.ProductFindByNameDao;
import com.training.Product;
import com.training.service.ProductFindByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl extends AbstractServiceIml<Product> implements ProductFindByNameService {

    private final ProductFindByNameDao findName;

    @Autowired
    public ProductServiceImpl(ProductFindByNameDao findName) {
        this.findName = findName;
    }

    @Override
    public Product findByName(String name) {
        return findName.findByName(name);
    }
}
