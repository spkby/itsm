package by.itsm.patients.web.service.impl;

import by.itsm.patients.common.entity.Sale;
import by.itsm.patients.web.model.SaleDto;
import by.itsm.patients.web.service.AbstractCrudService;
import by.itsm.patients.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class SaleService extends AbstractCrudService<Sale, SaleDto> {

    @Autowired
    public SaleService(
            JpaRepository<Sale, Integer> repository,
            Converter<Sale, SaleDto> converter
    ) {
        super(repository, converter);
    }

    @Override
    public void save(SaleDto dto) {
        Sale entity = converter.convert(dto);

        Integer patStateId = entity.getPatient().getState().getId();
        Integer prdStateId = entity.getProduct().getState().getId();

        if (!Objects.equals(patStateId, prdStateId)) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        repository.save(entity);
    }
}
