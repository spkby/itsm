package com.training.web.service.converter.impl;

import com.training.Patient;
import com.training.Product;
import com.training.Transaction;
import com.training.web.model.TransactionIDto;
import com.training.web.repository.PatientRepository;
import com.training.web.repository.ProductRepository;
import com.training.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionConvert  implements Converter<Transaction, TransactionIDto> {

    private final PatientRepository patientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TransactionConvert(PatientRepository patientRepository, ProductRepository productRepository) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public TransactionIDto convert(Transaction entity) {
        TransactionIDto dto = new TransactionIDto();
        dto.setPatient_id(entity.getPatient_id().getId());
        dto.setProduct_id(entity.getProduct_id().getId());
        dto.setDate(entity.getDate());
        return dto;
    }

    @Override
    public Transaction convert(TransactionIDto dto) {
        Patient patient = patientRepository
                .findById(dto.getPatient_id())
                .orElseThrow(() -> new IllegalArgumentException("Can't find patient with id = " + dto.getPatient_id()));

        Product product = productRepository
                .findById(dto.getProduct_id())
                .orElseThrow(() -> new IllegalArgumentException("Can't find product with id = " + dto.getProduct_id()));

        Transaction entity = new Transaction();

        entity.setId(dto.getId());
        entity.setDate(dto.getDate());

        entity.setPatient_id(patient);
        entity.setProduct_id(product);

        return entity;
    }
}
