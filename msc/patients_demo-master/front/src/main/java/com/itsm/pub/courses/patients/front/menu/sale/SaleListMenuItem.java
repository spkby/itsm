package com.itsm.pub.courses.patients.front.menu.sale;

import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.repository.domain.IProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class SaleListMenuItem implements IMenuItem {

    private final IProductSaleRepository  saleRepository;

    @Autowired
    public SaleListMenuItem(IProductSaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public String getTitle() {
        return "Print all sales";
    }

    @Override
    @Transactional
    public int doAction() {
        saleRepository.findAll().forEach(System.out::println);
        return 0;
    }
}
