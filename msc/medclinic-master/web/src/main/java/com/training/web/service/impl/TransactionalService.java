package com.training.web.service.impl;

import com.training.Transaction;
import com.training.web.model.TransactionIDto;
import com.training.web.service.AbstractCrudService;
import com.training.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class TransactionalService extends AbstractCrudService<Transaction, TransactionIDto> {

    @Autowired
    public TransactionalService(JpaRepository<Transaction, Integer> repository, Converter<Transaction, TransactionIDto> converter) {
        super(repository, converter);
    }

    @Override
    public void save(TransactionIDto dto) {
        Transaction entity = converter.convert(dto);

        Integer patStateId = entity.getPatient_id().getState_id().getId();
        Integer prdStateId = entity.getProduct_id().getState().getId();

        if (!Objects.equals(patStateId, prdStateId)) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        repository.save(entity);
    }
}
