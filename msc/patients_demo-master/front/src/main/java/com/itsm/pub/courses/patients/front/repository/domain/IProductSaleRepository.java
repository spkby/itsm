package com.itsm.pub.courses.patients.front.repository.domain;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.front.repository.IListRepository;

public interface IProductSaleRepository extends IListRepository<ProductSale> {

    void sale(Product product, Patient patient);
}
