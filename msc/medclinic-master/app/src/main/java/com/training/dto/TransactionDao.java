package com.training.dto;

import com.training.Patient;
import com.training.Product;
import com.training.Transaction;
import com.training.service.EntityListIdService;

public interface TransactionDao extends EntityCrudDao<Transaction>,
        EntityListIdDao<Transaction>{
    void transaction(Product product, Patient patient);
}
