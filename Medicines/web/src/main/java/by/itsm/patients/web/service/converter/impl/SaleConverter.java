package by.itsm.patients.web.service.converter.impl;

import by.itsm.patients.logic.Utils;
import by.itsm.patients.web.service.converter.Converter;
import by.itsm.patients.common.entity.Patient;
import by.itsm.patients.common.entity.Product;
import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.web.model.SaleDto;
import by.itsm.patients.web.repository.PatientRepository;
import by.itsm.patients.web.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleConverter implements Converter<Sale, SaleDto> {

    private final PatientRepository patientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public SaleConverter(
            PatientRepository patientRepository,
            ProductRepository productRepository
    ) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public SaleDto convert(Sale entity) {
        SaleDto dto = new SaleDto();

        dto.setPatientId(entity.getPatient().getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setDate(Utils.convertLocalDateTimeToDate(entity.getDate()));

        return dto;
    }

    @Override
    public Sale convert(SaleDto dto) {
        Patient patient = patientRepository
                .findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find patient with id = " + dto.getPatientId()));

        Product product = productRepository
                .findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find product with id = " + dto.getProductId()));

        Sale entity = new Sale();

        entity.setId(dto.getId());
        entity.setDate(Utils.convertDateToLocalDateTime(dto.getDate()));

        entity.setPatient(patient);
        entity.setProduct(product);

        return entity;
    }
}
