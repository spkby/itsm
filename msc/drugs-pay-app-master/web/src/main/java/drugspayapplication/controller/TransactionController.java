package drugspayapplication.controller;

import drugspayapplication.entity.Transaction;
import drugspayapplication.service.TransactionService;
import drugspayapplication.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sales")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/")
    @ResponseBody
    void postTransaction(@RequestBody Transaction transaction) {
        transactionService.postTransaction(transaction);
    }

    @GetMapping("/")
    @ResponseBody
    Iterable<Transaction> getAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Transaction getTransaction(@PathVariable Long id) {
        return transactionService.findById(id);
    }

    @GetMapping("/deleteById/{id}")
    @ResponseBody
    Long deleteState(@PathVariable Long id) {
        transactionService.deleteById(id);
        return id;
    }

}
