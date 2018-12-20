package com.itsm.pub.courses.patients.front.menu.product;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.menu.util.ConsoleFactory;
import com.itsm.pub.courses.patients.front.menu.util.MenuHelper;
import com.itsm.pub.courses.patients.front.repository.domain.impl.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConsoleFactory implements ConsoleFactory<Product> {

    private final MenuHelper helper;
    private final StateRepository stateRepository;



    @Autowired
    public ProductConsoleFactory(
            MenuHelper helper,
            StateRepository stateRepository) {
        this.helper = helper;
        this.stateRepository = stateRepository;
    }

    @Override
    public Product create() {
        Product product = new Product();
        update(product);
        return product;
    }

    @Override
    public void update(Product product) {
        System.out.println("Input name:");
        String name = helper.read();


        System.out.println("Input state code");
        String stateCode = helper.read();

        State state = stateRepository.findByCode(stateCode);

        product.setName(name);
        product.setState(state);
    }
}
