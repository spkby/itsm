package com.training.dto.impl;

import com.training.dto.EntityCrudDao;
import com.training.dto.EntityListIdDao;
import com.training.IEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

public abstract class AbstractDaoImpl<T extends IEntity> implements EntityCrudDao<T>,
        EntityListIdDao<T> {

    private final static Logger logger = LogManager.getLogger(AbstractDaoImpl.class);

    @PersistenceContext
    protected EntityManager em;

    @Override
    public void create(T t) {
        if (t != null) {
            try {
                em.persist(t);
                logger.info("Created successful!");
            } catch (RuntimeException e) {
                e.printStackTrace();
                logger.error("Create failed!");
            }
        }
    }

    @Override
    public void update(T t) {
        try {
            em.merge(t);
            logger.info("Updated successful!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.error("Update failed!");
        }
    }

    @Override
    public void delete(T t) {
        try {
            em.remove(em.contains(t) ? t : em.merge(t));
            logger.info("Removed successful!");
        } catch (RuntimeException e) {
            e.printStackTrace();
            logger.error("Remove failed");
        }
    }

    @Override
    public List<T> getAll() {
        logger.info("Finding all");
        TypedQuery<T> query = em.createQuery("from " + getEntityClass().getAnnotation(Entity.class).name(), getEntityClass());
        return query.getResultList();
    }


    protected abstract Class<T> getEntityClass();

    @Override
    public T findById(Integer id) {
        logger.info("Finding with id: " + id);
        return em.find(getEntityClass(), id);
    }


}
