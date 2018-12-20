package com.training.dto.impl;

import com.training.dto.StateFindByCodeDao;
import com.training.State;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class StateDaoImpl extends AbstractDaoImpl<State> implements StateFindByCodeDao {

    private final static Logger logger = LogManager.getLogger(StateDaoImpl.class);

    @Override
    protected Class<State> getEntityClass() {
        return State.class;
    }

    @Override
    public State findByCode(String name) {
        logger.info("Finding code with name: " + name);
        TypedQuery<State> query = em.createQuery("select s from states s where s.code = :code", getEntityClass());
        query.setParameter("code", name);
        return query.getSingleResult();
    }
}
