package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.repository.AbstractListRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IStateRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class StateRepository extends AbstractListRepository<State> implements IStateRepository {

    @Override
    protected Class<State> getEntityClass() {
        return State.class;
    }

    @Override
    public State findByCode(String code) {
        TypedQuery<State> query = em.createQuery("select s from state s where s.code = :code", State.class);
        query.setParameter("code", code);
        return query.getSingleResult();
    }
}
