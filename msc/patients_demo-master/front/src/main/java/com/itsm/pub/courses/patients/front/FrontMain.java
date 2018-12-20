package com.itsm.pub.courses.patients.front;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.front.config.FrontConfig;
import com.itsm.pub.courses.patients.front.context.UserNameHolder;
import com.itsm.pub.courses.patients.front.repository.IListRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IPatientRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class FrontMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FrontConfig.class);
        context.registerShutdownHook();

        System.out.println("Hello, what's your name? ");
        String name = new Scanner(System.in).next();

        UserNameHolder holder = context.getBean(UserNameHolder.class);
        holder.login(name);

        Runnable mainMenu = (Runnable) context.getBean("mainMenu");
        mainMenu.run();
    }
}
