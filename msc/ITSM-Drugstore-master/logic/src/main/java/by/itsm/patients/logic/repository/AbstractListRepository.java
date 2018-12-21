package by.itsm.patients.logic.repository;

import by.itsm.patients.common.entity.IEntity;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractListRepository<T extends IEntity> implements IListRepository<T> {

    @PersistenceContext
    protected EntityManager em;

    protected Class<T> typeClass;

    @Override
    public List<T> findAll() {
        TypedQuery<T> query =
                em.createQuery("from " + typeClass.getAnnotation(Entity.class).name(), typeClass);
        return query.getResultList();
    }

    @Override
    public T find(Integer id) {
        return em.find(typeClass, id);
    }
}
