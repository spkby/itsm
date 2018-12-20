package by.itsm.patients.logic.service;

import by.itsm.patients.logic.context.Auditable;
import by.itsm.patients.logic.repository.ICrudRepository;
import by.itsm.patients.common.entity.IEntity;
import by.itsm.patients.logic.exception.DatabaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public abstract class AbstractCrudService<T extends IEntity>
        extends AbstractListService<T>
        implements ICrudService<T> {

    @Autowired
    protected ICrudRepository<T> repository;

    @Autowired
    protected TransactionTemplate txTemplate;

    @Auditable
    @Transactional
    public void create(T t) {

        txTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    repository.create(t);
                } catch (DatabaseException e) {
                    status.setRollbackOnly();
                    throw e;
                }
            }
        });
    }

    @Auditable
    @Transactional
    public void update(T t) {

        txTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    repository.update(t);
                } catch (DatabaseException e) {
                    status.setRollbackOnly();
                    throw e;
                }
            }
        });
    }

    @Auditable
    @Transactional
    public void delete(final T t) {

        txTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try {
                    repository.delete(t);
                } catch (DatabaseException e) {
                    status.setRollbackOnly();
                    throw e;
                }
            }
        });
    }
}
