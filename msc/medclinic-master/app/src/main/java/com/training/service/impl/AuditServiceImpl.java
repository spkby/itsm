package com.training.service.impl;

import com.training.dto.AuditDao;
import com.training.AuditOperation;
import com.training.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditServiceImpl extends AbstractServiceIml<AuditOperation> implements AuditService {

    private final AuditDao auditDao;

    @Autowired
    public AuditServiceImpl(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    @Override
    public void create(boolean success, String name, Object... params) {
        auditDao.create(success, name, params != null ? params : new Object[0]);
    }
}
