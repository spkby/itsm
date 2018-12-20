package by.itsm.patients.logic.repository.domain.impl;

import by.itsm.patients.common.entity.State;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.AbstractListRepository;
import by.itsm.patients.logic.repository.domain.IStateRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class StateRepository extends AbstractListRepository<State> implements IStateRepository {

    public StateRepository() {
        typeClass = State.class;
    }

    @Override
    @Transactional
    public State findByCode(String code) {
        try {
            TypedQuery<State> query = em.createQuery("select s from state s where s.code = :code", State.class);
            query.setParameter("code", code);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (DatabaseException e) {
            throw e;
        }
    }
}
