package front.DAO.impl;

import front.DAO.AbstractCRUDOperations;
import front.models.Audit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuditDAO extends AbstractCRUDOperations<Audit> implements IAuditDAO {

    @Override
    public void create(Audit audit) {
        em.persist(audit);
    }

    @Override
    public Audit find(Integer id) {
        return em.find(Audit.class,id);
    }

    public void update(Audit audit) {
        em.merge(audit);
    }

    public void remove(Integer id) {
        Audit audit = em.find(Audit.class, id);
        em.remove(audit);
    }

    @Override
    public List<Audit> findAll() {
        return null;
    }
}
