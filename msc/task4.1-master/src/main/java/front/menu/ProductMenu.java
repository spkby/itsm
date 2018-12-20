package front.menu;

import front.DAO.impl.IProductDAO;
import front.DAO.impl.IStateDAO;
import front.models.Product;
import front.models.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import front.utils.UserHelper;

import java.time.LocalDateTime;

@Component
public class ProductMenu extends AbstractMenu implements IProductMenu {

    private final int lowerBound = 1;
    private final int upperBound = 5;

    @Autowired
    IMainMenu mainMenu;

    @Autowired
    IStateDAO stateDAO;

    @Autowired
    IProductDAO productDAO;

    public ProductMenu() {
    }

    public void getMenu() {
        System.out.println(
                "Product menu:\n" +
                        "1. Create new product\n" +
                        "2. Show product by ID\n" +
                        "3. Update product's data\n" +
                        "4. Delete product by ID\n" +
                        "5. Back to the Pharmacy IMenu");
    }

    public void performEnteredValue(int numberOfOperation) {
        switch (numberOfOperation) {
            case 1: {
                createNewProduct();
                break;
            }
            case 2: {
                showProductById();
                break;
            }
            case 3: {
                updateProductById();
            }
            break;
            case 4: {
                deleteProductById();
            }

            break;
            case 5: {
                mainMenu.performMenu();  //return to the Main menu
            }
            break;
            default:
                System.out.printf("You entered %d\n", numberOfOperation);
                getOutOfBoundsNotification(lowerBound, upperBound);
        }
    }

    private void createNewProduct() {
        System.out.println("Type in new product name");
        String productName = readStringClauseConsole();

        System.out.println("Type in product's State code (NY, AL, etc)");
        String stateName = readStringClauseConsole();
        State state = stateDAO.findStateByName(stateName);

        Product product = new Product(productName, state, UserHelper.getCurrentUser(), LocalDateTime.now(),UserHelper.getCurrentUser(),LocalDateTime.now());
        productDAO.create(product);
        System.out.println("The following product has just been created: " + product);
        performMenu();
    }

    private void updateProductById() {
        System.out.println("Enter product ID");
        Integer productId = readMenuClauseConsole();
        Product product = productDAO.find(productId);

        System.out.println("Type in new product name");
        String productName = readStringClauseConsole();

        System.out.println("Type in product's State code (NY, AL, etc)");
        String stateName = readStringClauseConsole();
        State state = stateDAO.findStateByName(stateName);

        product.setName(productName);
        product.setState(state);
        product.setModifiedByUser(UserHelper.getCurrentUser());
        product.setUpdatedDate(LocalDateTime.now());

        productDAO.update(product);
        System.out.println("The following product has just been updated: " + product);
        performMenu();
    }

    private void showProductById() {
        System.out.println("Enter product ID");
        Integer productId = readMenuClauseConsole();
        Product product = productDAO.find(productId);
        if (product == null) {
            System.out.println("There is no such a product ID. Please try to use another ID");
        } else {
            System.out.println(product);
        }
        performMenu();
    }

    private void deleteProductById() {
        System.out.println("Enter product ID");
        Integer productId = readMenuClauseConsole();
        productDAO.remove(productId);
        performMenu();
    }
}
