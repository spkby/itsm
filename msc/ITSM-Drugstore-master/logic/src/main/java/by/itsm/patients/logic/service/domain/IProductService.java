package by.itsm.patients.logic.service.domain;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.logic.service.ICrudService;

public interface IProductService extends ICrudService<Product> {

//    Product getNew(String productName, Integer stateId);
//
//    Product getExist(String productName);

    Product getByProductName(String productName);


}
