package com.training.dto;

import com.training.Product;

public interface ProductFindByNameDao extends EntityCrudDao<Product> {
    Product findByName(String name);
}
