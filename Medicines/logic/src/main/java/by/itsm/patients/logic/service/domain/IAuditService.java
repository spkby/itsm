package by.itsm.patients.logic.service.domain;

import by.itsm.patients.common.entity.AuditOperation;
import by.itsm.patients.common.entity.User;
import by.itsm.patients.logic.service.ICrudService;

public interface IAuditService extends ICrudService<AuditOperation> {

    void add(boolean success, User user, Object... params);
}
