package drugspayapplication.service;

import drugspayapplication.entity.Transaction;
import drugspayapplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public boolean postTransaction(Transaction transaction) {
        boolean flag = transaction.getPatient().getState() - transaction.getProduct().getState() == 0;
        if (flag) transactionRepository.save(transaction);
        return flag;
    }

    @Override
    public Iterable<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }
}
