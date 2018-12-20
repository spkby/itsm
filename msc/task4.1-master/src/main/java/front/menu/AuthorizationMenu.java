package front.menu;

import front.DAO.impl.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class AuthorizationMenu extends MenuHelper implements IAuthorizationMenu {

    @Autowired
    IUserDAO userDAO;

    @Autowired
    IMainMenu mainMenu;

    @Override
    public void performMenu() {
        System.out.println("Welcome to Pharmacy:");
        System.out.println("Please fill in your Login");
        String login = readStringClauseConsole();

        System.out.println("Please fill in your Password");
        String password = readStringClauseConsole();

        if (userDAO.verifyUserByLoginAndPassword(login, password)) {
            mainMenu.performMenu();
        } else {
            System.out.println("Credentials are invalid. Try again");
            performMenu();
        }
    }
}
