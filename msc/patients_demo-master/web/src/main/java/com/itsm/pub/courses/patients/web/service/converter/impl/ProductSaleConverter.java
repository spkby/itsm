package com.itsm.pub.courses.patients.web.service.converter.impl;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.web.model.ProductSaleDto;
import com.itsm.pub.courses.patients.web.repository.PatientRepository;
import com.itsm.pub.courses.patients.web.repository.ProductRepository;
import com.itsm.pub.courses.patients.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSaleConverter implements Converter<ProductSale, ProductSaleDto> {

    private final PatientRepository patientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductSaleConverter(
            PatientRepository patientRepository,
            ProductRepository productRepository
    ) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductSaleDto convert(ProductSale entity) {
        ProductSaleDto dto = new ProductSaleDto();

        dto.setPatientId(entity.getPatient().getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setDate(entity.getDate());

        return dto;
    }

    @Override
    public ProductSale convert(ProductSaleDto dto) {
        Patient patient = patientRepository
                .findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find patient with id = " + dto.getPatientId()));

        Product product = productRepository
                .findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find product with id = " + dto.getProductId()));

        ProductSale entity = new ProductSale();

        entity.setId(dto.getId());
        entity.setDate(dto.getDate());

        entity.setPatient(patient);
        entity.setProduct(product);

        return entity;
    }
}
