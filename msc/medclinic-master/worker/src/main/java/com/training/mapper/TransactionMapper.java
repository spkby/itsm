package com.training.mapper;

import com.training.Transaction;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TransactionMapper {

    Transaction getIdTransaction(int id);
    List<Transaction> getListTransaction();
}
