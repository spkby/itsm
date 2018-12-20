package com.itsm.pub.courses.patients.front.repository.domain;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;

public interface IProductRepository extends ICrudRepository<Product> {
    Product findByName(String name);
}
