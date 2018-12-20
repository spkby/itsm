package com.itsm.pub.courses.patients.web.service.impl;

import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.web.model.ProductSaleDto;
import com.itsm.pub.courses.patients.web.service.AbstractCrudService;
import com.itsm.pub.courses.patients.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class ProductSaleService extends AbstractCrudService<ProductSale, ProductSaleDto> {

    @Autowired
    public ProductSaleService(
            JpaRepository<ProductSale, Integer> repository,
            Converter<ProductSale, ProductSaleDto> converter
    ) {
        super(repository, converter);
    }

    @Override
    public void save(ProductSaleDto dto) {
        ProductSale entity = converter.convert(dto);

        Integer patStateId = entity.getPatient().getState().getId();
        Integer prdStateId = entity.getProduct().getState().getId();

        if (!Objects.equals(patStateId, prdStateId)) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        repository.save(entity);
    }
}
