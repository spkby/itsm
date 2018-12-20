package com.training.dto.impl;

import com.training.context.Auditable;
import com.training.dto.TransactionDao;
import com.training.Patient;
import com.training.Product;
import com.training.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class TransactionDaoImpl extends AbstractDaoImpl<Transaction> implements TransactionDao {

    private final static Logger logger = LogManager.getLogger(TransactionDaoImpl.class);

    @Override
    protected Class<Transaction> getEntityClass() {
        return Transaction.class;
    }

    @Override
    @Auditable
    public void transaction(Product product, Patient patient) {
        if (!product.getState().getId().equals(patient.getState_id().getId())){
            logger.error("Patient and Product doesn't match!");
            throw new IllegalArgumentException("Patient and Product doesn't match!");
        }

        logger.info("Transaction between Product and Patient");
        Transaction transaction = new Transaction(null,patient,product,new Date());
        em.persist(transaction);
    }
}
