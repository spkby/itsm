package by.itsm.patients.console;

import by.itsm.patients.common.entity.User;
import by.itsm.patients.console.menu.MainMenu;
import by.itsm.patients.logic.context.UserHolder;
import by.itsm.patients.logic.service.domain.IAuditService;
import by.itsm.patients.logic.service.domain.IUserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ConsoleApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsoleConfig.class);
        context.registerShutdownHook();

        System.out.println("Enter your name ");
        String name = new Scanner(System.in).next();

        System.out.println("Enter your password ");
        String password = enterPassword();

        User user = context.getBean(IUserService.class).loggedUser(name, password);
        if (user == null) {
            System.out.println("User not found");
            return;
        }

        UserHolder holder = context.getBean(UserHolder.class);
        holder.login(user);

        context.getBean(IAuditService.class).add(true, user, "logged");

        Runnable mainMenu = (Runnable) context.getBean(MainMenu.class);
        mainMenu.run();

    }


    private static String enterPassword() {
        return System.console() != null ?
                String.valueOf(System.console().readPassword()) : new Scanner(System.in).nextLine();
    }
}
