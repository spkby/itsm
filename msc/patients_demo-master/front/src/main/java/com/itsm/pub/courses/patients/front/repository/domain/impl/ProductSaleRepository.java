package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.front.context.Auditable;
import com.itsm.pub.courses.patients.front.repository.AbstractListRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IProductSaleRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ProductSaleRepository extends AbstractListRepository<ProductSale> implements IProductSaleRepository {

    @Override
    protected Class<ProductSale> getEntityClass() {
        return ProductSale.class;
    }

    @Override
    @Auditable
    public void sale(Product product, Patient patient) {
        if (!product.getState().equals(patient.getState())) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        ProductSale sale = new ProductSale(
                null,
                patient,
                product,
                new Date()
        );

        em.persist(sale);
    }
}
