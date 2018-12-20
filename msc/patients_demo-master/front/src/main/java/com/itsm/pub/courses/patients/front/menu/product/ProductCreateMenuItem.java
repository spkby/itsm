package com.itsm.pub.courses.patients.front.menu.product;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.menu.patient.PatientMenuItem;
import com.itsm.pub.courses.patients.front.menu.util.ConsoleFactory;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ProductMenuItem
public class ProductCreateMenuItem implements IMenuItem {

    private final ConsoleFactory<Product> productConsoleFactory;
    private final ICrudRepository<Product> patientRepository;

    @Autowired
    public ProductCreateMenuItem(
            ConsoleFactory<Product> productConsoleFactory,
            ICrudRepository<Product> patientRepository) {
        this.productConsoleFactory = productConsoleFactory;
        this.patientRepository = patientRepository;
    }

    @Override
    public String getTitle() {
        return "Add product";
    }

    @Override
    public int doAction() {
        Product product = productConsoleFactory.create();
        patientRepository.create(product);
        return 0;
    }
}
