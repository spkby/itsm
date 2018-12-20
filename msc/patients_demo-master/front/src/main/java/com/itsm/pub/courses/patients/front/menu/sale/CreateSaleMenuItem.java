package com.itsm.pub.courses.patients.front.menu.sale;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.menu.util.MenuHelper;
import com.itsm.pub.courses.patients.front.repository.domain.IPatientRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IProductRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class CreateSaleMenuItem implements IMenuItem {

    private final IPatientRepository patientRepository;
    private final IProductRepository productRepository;
    private final IProductSaleRepository saleRepository;
    private final MenuHelper helper;

    @Autowired
    public CreateSaleMenuItem(
            IPatientRepository patientRepository,
            IProductRepository productRepository,
            IProductSaleRepository saleRepository,
            MenuHelper helper) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.helper = helper;
    }

    @Override
    public String getTitle() {
        return "Make sale";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("input patient phone: ");
        String phone = helper.read();

        Patient patient = patientRepository.findByPhone(phone);
        if (patient == null) {
            System.out.println("Patient not found");
            return 0;
        }

        System.out.println("input product name");
        String name = helper.read();

        Product product = productRepository.findByName(name);
        if (product == null) {
            System.out.println("product not found");
            return 0;
        }

        try {
            saleRepository.sale(product, patient);
        } catch (Exception e) {
            System.out.println("failed to complete sale");
            e.printStackTrace();
        }

        return 0;
    }
}
