package by.itsm.patients.logic.repository;

import by.itsm.patients.common.entity.IEntity;
import by.itsm.patients.logic.context.UserHolder;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractCrudRepository<T extends IEntity>
        extends AbstractListRepository<T>
        implements ICrudRepository<T> {

    @Override
    @Transactional
    public void create(T t) {
        t.setCreatedBy(UserHolder.getCurrentUser());
        em.persist(t);
    }

    @Override
    @Transactional
    public void update(T t) {
        t.setUpdatedBy(UserHolder.getCurrentUser());
        em.merge(t);
    }

    @Override
    @Transactional
    public void delete(T t) {
        em.remove(t);
    }

}
