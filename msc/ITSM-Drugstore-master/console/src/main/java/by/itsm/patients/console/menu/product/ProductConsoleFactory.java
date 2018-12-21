package by.itsm.patients.console.menu.product;

import by.itsm.patients.common.entity.Product;
import by.itsm.patients.common.entity.State;
import by.itsm.patients.console.menu.util.ConsoleFactory;
import by.itsm.patients.console.menu.util.MenuHelper;
import by.itsm.patients.logic.service.domain.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConsoleFactory implements ConsoleFactory<Product> {

    @Autowired
    private IStateService stateService;
    @Autowired
    private MenuHelper helper;

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

        State state = stateService.findByCode(stateCode);

        product.setName(name);
        product.setState(state);
    }
}
