package com.training.dto.impl;

import com.training.dto.AuditDao;
import com.training.AuditOperation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Repository
public class AuditDaoImpl extends AbstractDaoImpl<AuditOperation> implements AuditDao {

    protected Class<AuditOperation> getEntityClass() {
        return AuditOperation.class;
    }

    @Override
    @Transactional
    public void create(boolean success, Object name, Object... params) {
        String data = Arrays.stream(params)
                .map(Object::toString)
                .collect(Collectors.joining(";"));

        data = name + " : " + data;

        AuditOperation operation = new AuditOperation(null, new Date(), success, data);
        em.persist(operation);
    }
}
