package com.training.web.service.impl;

import com.training.User;
import com.training.web.model.UserIDto;
import com.training.web.service.AbstractCrudService;
import com.training.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuditService extends AbstractCrudService<User, UserIDto> {
    @Autowired
    public AuditService(JpaRepository<User, Integer> repository, Converter<User, UserIDto> converter) {
        super(repository, converter);
    }
}
