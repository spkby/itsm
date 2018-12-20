package com.training.dto.impl;

import com.training.dto.ProductFindByNameDao;
import com.training.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class ProductDaoImpl extends AbstractDaoImpl<Product> implements ProductFindByNameDao {

    private final static Logger logger = LogManager.getLogger(ProductDaoImpl.class);

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    public Product findByName(String name) {
        logger.info("Finding product with name: " + name);
        TypedQuery<Product> query = em.createQuery("select p from products p where p.name = :name", getEntityClass());
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
