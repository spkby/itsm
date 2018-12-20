package drugspayapplication.mybatis.dao;


import drugspayapplication.mybatis.dao.mapper.TransactionMapper;
import drugspayapplication.mybatis.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;

@Component
public class TransactionDao {

	@Autowired
	TransactionMapper mapper;

	public List<Transaction> getTransactions(Timestamp dateFrom, Timestamp dateTo) {
		return mapper.getTransactions(dateFrom, dateTo);
	}
}
