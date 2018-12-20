package by.itsm.patients.web.service.impl;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.web.model.ProductDto;
import by.itsm.patients.web.service.AbstractCrudService;
import by.itsm.patients.web.service.converter.Converter;
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
