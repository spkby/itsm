package com.training;

import com.training.config.SpringConfig;
import com.training.menu.user.UserAuthorization;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        Runnable mainMenu = context.getBean(UserAuthorization.class);
        mainMenu.run();
    }
}
