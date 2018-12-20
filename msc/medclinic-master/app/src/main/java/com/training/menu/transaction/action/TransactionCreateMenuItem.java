package com.training.menu.transaction.action;

import com.training.Patient;
import com.training.Product;
import com.training.menu.IMenuItem;
import com.training.menu.transaction.TransactionMenuItem;
import com.training.menu.util.MenuHelper;
import com.training.service.PatientFindByNameService;
import com.training.service.ProductFindByNameService;
import com.training.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@TransactionMenuItem
public class TransactionCreateMenuItem implements IMenuItem {

    private final PatientFindByNameService patientService;
    private final ProductFindByNameService productService;
    private final TransactionService transactionService;
    private final MenuHelper helper;

    @Autowired
    public TransactionCreateMenuItem(PatientFindByNameService patientService, ProductFindByNameService productService, TransactionService transactionService, MenuHelper helper) {
        this.patientService = patientService;
        this.productService = productService;
        this.transactionService = transactionService;
        this.helper = helper;
    }

    @Override
    public String getTitle() {
        return "Make transaction";
    }

    @Override
    @Transactional
    public int doAction() {
        System.out.println("input patient phone: ");
        String phone = helper.read();

        Patient patient = patientService.findByName(phone);
        if (patient == null) {
            System.out.println("Patient not found");
            return 0;
        }

        System.out.println("input product name");
        String name = helper.read();

        Product product = productService.findByName(name);
        if (product == null) {
            System.out.println("product not found");
            return 0;
        }

        try {
            transactionService.transaction(product, patient);
        } catch (Exception e) {
            System.out.println("failed to complete sale");
            e.printStackTrace();
        }
        return 0;
    }
}
