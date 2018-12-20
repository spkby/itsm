package com.training.web.controller.impl;

import com.training.Transaction;
import com.training.web.controller.AbstractCrudController;
import com.training.web.model.TransactionIDto;
import com.training.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController extends AbstractCrudController<Transaction, TransactionIDto> {

    @Autowired
    public TransactionController(ICrudService<Transaction, TransactionIDto> service) {
        super(service);
    }
}
