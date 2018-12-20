package front.DAO.impl;

import front.DAO.ICRUDOperations;
import front.models.Product;

public interface IProductDAO extends ICRUDOperations<Product> {

    Product findProductByProductName(String productName);
}
