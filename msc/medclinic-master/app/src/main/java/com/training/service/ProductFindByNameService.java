package com.training.service;

import com.training.Product;

public interface ProductFindByNameService extends EntityCrudService<Product> {
    Product findByName(String name);
}
