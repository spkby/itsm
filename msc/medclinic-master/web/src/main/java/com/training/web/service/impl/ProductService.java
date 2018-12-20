package com.training.web.service.impl;

import com.training.Product;
import com.training.web.model.ProductIDto;
import com.training.web.service.AbstractCrudService;
import com.training.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService extends AbstractCrudService<Product, ProductIDto> {

    @Autowired
    public ProductService(JpaRepository<Product, Integer> repository, Converter<Product, ProductIDto> converter) {
        super(repository, converter);
    }
}
