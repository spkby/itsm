package com.training.service;

import com.training.Patient;
import com.training.Product;
import com.training.Transaction;

public interface TransactionService extends EntityListIdService<Transaction> {
    void transaction(Product product, Patient patient);
}
