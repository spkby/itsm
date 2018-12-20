package com.training.service.impl;

import com.training.dto.TransactionDao;
import com.training.Patient;
import com.training.Product;
import com.training.Transaction;
import com.training.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl extends AbstractServiceIml<Transaction> implements TransactionService{

    private final TransactionDao transactionDao;

    @Autowired
    public TransactionServiceImpl(TransactionDao transactionDao) {
        super(transactionDao, transactionDao);
        this.transactionDao = transactionDao;
    }

    @Override
    public void transaction(Product product, Patient patient) {
        transactionDao.transaction(product,patient);
    }
}
