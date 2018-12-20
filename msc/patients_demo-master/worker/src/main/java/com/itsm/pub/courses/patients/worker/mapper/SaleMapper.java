package com.itsm.pub.courses.patients.worker.mapper;

import com.itsm.pub.courses.patients.common.entities.ProductSale;

import java.util.List;

public interface SaleMapper {
    ProductSale getSale(int saleId);
    List<ProductSale> getSaleList();
}
