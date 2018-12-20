package com.itsm.pub.courses.patients.front.repository;

import com.itsm.pub.courses.patients.common.entities.IEntity;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractCrudRepository<E extends IEntity>
        extends AbstractListRepository<E>
        implements ICrudRepository<E> {

    @Override
    @Transactional
    public void create(E e) {
        em.persist(e);
    }

    @Override
    @Transactional
    public void update(E e) {
        em.merge(e);
    }

    @Override
    @Transactional
    public void delete(E e) {
        em.remove(e);
    }
}
