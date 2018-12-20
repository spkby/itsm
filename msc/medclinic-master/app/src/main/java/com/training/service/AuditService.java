package com.training.service;

import com.training.AuditOperation;

public interface AuditService extends EntityListIdService<AuditOperation> {
    void create(boolean success, String name, Object... params);
}
