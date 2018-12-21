package by.itsm.patients.logic.service.domain.impl;

import by.itsm.patients.common.entity.AuditOperation;
import by.itsm.patients.common.entity.User;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.domain.IAuditRepository;
import by.itsm.patients.logic.service.AbstractCrudService;
import by.itsm.patients.logic.service.domain.IAuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class AuditService extends AbstractCrudService<AuditOperation> implements IAuditService {

    @Autowired
    private IAuditRepository repository;

    @Transactional
    @Override
    public void add(boolean success, User user, Object... params) {
        try {
            String data = Arrays.stream(params)
                    .map(Object::toString)
                    .collect(Collectors.joining(";"));

            data = user.getName() + " : " + data;

            AuditOperation record = new AuditOperation(
                    success,
                    data
            );

            repository.create(record);

        } catch (DatabaseException e) {
            throw e;
        }
    }
}
