package com.itsm.pub.courses.patients.front.repository.domain;

import com.itsm.pub.courses.patients.common.entities.AuditRecord;
import com.itsm.pub.courses.patients.front.repository.IListRepository;

public interface IAuditRepository
        extends IListRepository<AuditRecord> {

    void create(boolean success, String userName,  Object... params);
}
