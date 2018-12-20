package front.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class MainMenu extends AbstractMenu implements IMainMenu {

    @Autowired
    IPatientMenu patientMenu;

    @Autowired
    IProductMenu productMenu;

    @Autowired
    ISellProductMenu sellProductMenu;
    private int lowerBound = 1;
    private int upperBound = 4;

    public void getMenu() {
        System.out.println(
                "Main menu:\n" +
                        "1. Patients\n" +
                        "2. Products\n" +
                        "3. Sell Product\n" +
                        "4. Quit");
    }


    public void performEnteredValue(int numberOfOperation) {
        switch (numberOfOperation) {
            case 1: {
                patientMenu.performMenu();
                break;
            }
            case 2: {
                productMenu.performMenu();
                break;
            }
            case 3:
                sellProductMenu.sellProduct();
                return;
            case 4:
                System.out.println("Closing the program...");
                return;
            default:
                System.out.printf("You entered %d\n", numberOfOperation);
                getOutOfBoundsNotification(lowerBound, upperBound);
        }
    }
}
