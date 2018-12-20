package com.training.dto;

import com.training.AuditOperation;

public interface AuditDao extends EntityListIdDao<AuditOperation> {
    void create(boolean success, Object name, Object... params);
}
