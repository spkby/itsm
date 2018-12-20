package com.training.menu.product;

import com.training.Product;
import com.training.State;
import com.training.menu.util.ConsoleFactory;
import com.training.menu.util.MenuHelper;
import com.training.service.EntityCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductConsoleFactory implements ConsoleFactory<Product> {

    private final MenuHelper helper;
    private final EntityCrudService<State> stateService;

    @Autowired
    public ProductConsoleFactory(MenuHelper helper, EntityCrudService<State> stateService) {
        this.helper = helper;
        this.stateService = stateService;
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

        System.out.println("Input state id:");
        printAllState();

        Integer statId = helper.readInt();
        State state = stateService.findById(statId);

        product.setName(name);
        product.setState(state);
    }

    private void printAllState() {
        List<State> states = stateService.getAll();
        for (int i = 0; i < states.size(); i++) {
            System.out.println((i + 1) + " " + states.get(i).getName());
        }
    }
}
