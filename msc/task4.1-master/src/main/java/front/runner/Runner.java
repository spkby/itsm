package front.runner;

import front.menu.IAuthorizationMenu;
import front.configuration.AppConfiguration;
import front.menu.IAuthorizationMenu;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfiguration.class);

        IAuthorizationMenu authorizationMenu = context.getBean(IAuthorizationMenu.class);
        authorizationMenu.performMenu();
    }
}
