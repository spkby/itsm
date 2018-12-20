package front.DAO;

import front.models.IEntity;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractCRUDOperations<E extends IEntity>
        implements ICRUDOperations<E> {

    @PersistenceContext
    protected EntityManager em;

    @Override

    @Transactional
    public abstract void create(E e);

    @Override

    @Transactional
    public abstract void update(E e);

    @Override

    @Transactional
    public abstract void remove(Integer id);

    @Override

    @Transactional
    public abstract E find(Integer id);
}
