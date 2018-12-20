package com.training.menu.user;

import com.training.context.PasswordSalt;
import com.training.context.UserHolder;
import com.training.User;
import com.training.menu.MainMenu;
import com.training.service.EntityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@Component
public class UserAuthorization implements Runnable {

    private final MainMenu mainMenu;
    private final PasswordSalt passwordSalt;
    private final UserHolder userHolder;
    private final EntityUserService userService;

    @Autowired
    public UserAuthorization(MainMenu mainMenu, PasswordSalt passwordSalt, UserHolder userHolder, EntityUserService userService) {
        this.mainMenu = mainMenu;
        this.passwordSalt = passwordSalt;
        this.userHolder = userHolder;
        this.userService = userService;
    }

    @Override
    public void run() {
        menuList();
        Scanner scanner = new Scanner(System.in);
        int item = scanner.nextInt();
        do {
            switch (item) {
                case 1: {
                    userRegistration();
                    return;
                }
                case 2: {
                    userEntrance();
                    return;
                }
            }
        } while (item != 3);
    }

    private void userRegistration() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.println("Please, enter login...");
        String login = scanner.nextLine();

        System.out.println("Please, enter password...");
        String password = scanner.nextLine();

        System.out.println("Enter email: ");
        String email = scanner.nextLine();

        String passwordSaltNew = null;

        try {
            passwordSaltNew = passwordSalt.createSalt(password);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        user.setLogin(login);
        user.setPassword(passwordSaltNew);
        user.setEmail(email);

        userService.getRegister(user);
        userHolder.setUser(user);
        System.out.println("Registration successful for " + login + "!");
        mainMenu.run();
    }

    private void userEntrance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, enter login...");
        String name = scanner.nextLine();

        System.out.println("Please, enter password...");
        String password = scanner.nextLine();

        User user = null;
        try {
            user = userService.getActiveUser(name, passwordSalt.createSalt(password));
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        if (user == null) {
            throw new IllegalArgumentException();
        }
        userHolder.setUser(user);
        mainMenu.run();
    }

    private void menuList() {
        System.out.println("User menu:");
        List<String> list = Arrays.asList(
                "Registration",
                "Entrance",
                "Exit"
        );
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + " " + list.get(i));
        }
    }
}
