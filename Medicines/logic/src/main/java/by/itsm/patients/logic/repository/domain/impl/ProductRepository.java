package by.itsm.patients.logic.repository.domain.impl;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.logic.exception.DatabaseException;
import by.itsm.patients.logic.repository.AbstractCrudRepository;
import by.itsm.patients.logic.repository.domain.IProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

@Repository
public class ProductRepository extends AbstractCrudRepository<Product> implements IProductRepository {

    public ProductRepository() {
        typeClass = Product.class;
    }

    @Override
    @Transactional
    public Product findByName(String name) {
        try {
            TypedQuery<Product> query = em.createQuery("select p from product p where p.name = :name", Product.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (DatabaseException e) {
            throw e;
        }
    }

}
