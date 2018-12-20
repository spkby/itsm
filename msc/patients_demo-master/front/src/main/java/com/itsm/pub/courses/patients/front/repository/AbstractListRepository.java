package com.itsm.pub.courses.patients.front.repository;

import com.itsm.pub.courses.patients.common.entities.IEntity;

import javax.persistence.*;
import java.util.List;

public abstract class AbstractListRepository<E extends IEntity> implements IListRepository<E> {

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<E> findAll() {
        TypedQuery<E> query =
                em.createQuery("from " + getEntityClass().getAnnotation(Entity.class).name(), getEntityClass());
        return query.getResultList();
    }

    @Override
    public E find(Integer id) {
        return em.find(getEntityClass(), id);
    }

    protected abstract Class<E> getEntityClass();
}
