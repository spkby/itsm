package front.DAO.impl;

import front.DAO.AbstractCRUDOperations;
import front.models.SellTransaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionDAO extends AbstractCRUDOperations<SellTransaction> implements ITransactionDAO {

    @Override
    public void create(SellTransaction sellTransaction) {
        em.persist(sellTransaction);
    }

    @Override
    public void update(SellTransaction sellTransaction) {
        em.merge(sellTransaction);

    }

    @Override
    public void remove(Integer id) {
        SellTransaction sellTransaction = em.find(SellTransaction.class, id);
        em.remove(sellTransaction);
    }

    @Override
    public List<SellTransaction> findAll() {
        return null;
    }

    @Override
    public SellTransaction find(Integer id) {
        SellTransaction sellTransaction = em.find(SellTransaction.class, id);
        return sellTransaction;
    }
}
