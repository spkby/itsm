package by.itsm.patients.logic.repository.domain.impl;

import by.itsm.patients.common.entity.AuditOperation;
import by.itsm.patients.logic.repository.AbstractCrudRepository;
import by.itsm.patients.logic.repository.domain.IAuditRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AuditRepository
        extends AbstractCrudRepository<AuditOperation>
        implements IAuditRepository {

    public AuditRepository() {
            typeClass = AuditOperation.class;
    }
}
