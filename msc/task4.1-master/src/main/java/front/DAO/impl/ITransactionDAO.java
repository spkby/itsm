package front.DAO.impl;

import front.DAO.IListRepository;
import front.models.SellTransaction;

public interface ITransactionDAO  extends IListRepository<SellTransaction> {
    void create(SellTransaction sellTransaction);

}
