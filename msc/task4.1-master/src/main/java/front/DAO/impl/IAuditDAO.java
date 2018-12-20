package front.DAO.impl;

import front.DAO.ICreateUpdateOperations;
import front.models.Audit;

public interface IAuditDAO extends ICreateUpdateOperations<Audit> {

    void create(Audit user);
    Audit find(Integer id);
}
