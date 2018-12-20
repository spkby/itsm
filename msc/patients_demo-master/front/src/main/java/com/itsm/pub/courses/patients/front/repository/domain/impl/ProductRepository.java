package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.front.repository.AbstractCrudRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class ProductRepository extends AbstractCrudRepository<Product> implements IProductRepository {

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    public Product findByName(String name) {
        TypedQuery<Product> query = em.createQuery("select p from product p where p.name = :name", Product.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

}
