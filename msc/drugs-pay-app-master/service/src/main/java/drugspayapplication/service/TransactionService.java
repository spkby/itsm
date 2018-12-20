package drugspayapplication.service;

import drugspayapplication.entity.Transaction;

public interface TransactionService {
    boolean postTransaction(Transaction transaction);

    Iterable<Transaction> findAll();

    Transaction findById(Long id);

    void deleteById(Long id);
}
