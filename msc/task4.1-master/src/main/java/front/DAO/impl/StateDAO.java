package front.DAO.impl;

import front.DAO.AbstractCRUDOperations;
import front.models.State;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StateDAO extends AbstractCRUDOperations<State> implements IStateDAO {

    protected Class<State> getEntityClass() {
        return null;
    }

    @Override
    public void create(State state) {
        em.persist(state);
    }

    @Override
    public void update(State state) {
        em.merge(state);
    }

    @Override
    public void remove(Integer id) {
        State state = em.find(State.class, id);
        em.remove(state);
    }

    @Override
    public List<State> findAll() {
        return null;
    }

    @Override
    public State find(Integer id) {
        return em.find(State.class, id);
    }

    public State findStateByName(String stateName) {
        TypedQuery<State> query = em.createQuery("select s from state s where st_name = :stateName", State.class);
        query.setParameter("stateName", stateName);
        return query.getSingleResult();
    }
}
