package com.itsm.pub.courses.patients.web.service.impl;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.web.model.ProductDto;
import com.itsm.pub.courses.patients.web.service.AbstractCrudService;
import com.itsm.pub.courses.patients.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProductService extends AbstractCrudService<Product, ProductDto> {

    @Autowired
    public ProductService(
            JpaRepository<Product, Integer> repository,
            Converter<Product, ProductDto> converter
    ) {
        super(repository, converter);
    }
}
