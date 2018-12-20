package front.DAO.impl;

import front.DAO.AbstractCRUDOperations;
import front.models.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDAO extends AbstractCRUDOperations<Product> implements IProductDAO {

    protected Class<Product> getEntityClass() {
        return null;
    }

    @Override
    public void create(Product product) {
        em.persist(product);
    }

    @Override
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public void remove(Integer id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product find(Integer id) {
        return em.find(Product.class, id);
    }

    @Override
    public Product findProductByProductName(String productName) {
        TypedQuery<Product> query = em.createQuery("select p from product p where product_name = :productName", Product.class);
        query.setParameter("productName", productName);
        return query.getSingleResult();
    }
}
