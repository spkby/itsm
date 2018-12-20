package by.itsm.patients.logic.repository.domain;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.logic.repository.ICrudRepository;

public interface IProductRepository extends ICrudRepository<Product> {
    Product findByName(String name);
}
