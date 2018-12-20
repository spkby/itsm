package front.menu;

import java.util.Scanner;

public abstract class AbstractMenu extends MenuHelper implements IMenu {

    public AbstractMenu() {
    }

    public void performMenu() {
        getMenu();
        Integer enteredValue = readMenuClauseConsole();
        performEnteredValue(enteredValue);
    }

    protected abstract void getMenu();

    protected abstract void performEnteredValue(int numberOfOperation);

    protected void getOutOfBoundsNotification(int lowerBound, int upperBound) {
        System.out.println(
                "You entered an invalid value. Please try again with integer value" +
                        " from " + lowerBound + " to " + upperBound + " inclusively.");
    }

}
