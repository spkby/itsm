package com.itsm.pub.courses.patients.front.context;

import org.springframework.stereotype.Component;

@Component
public class UserNameHolder {

    private static ThreadLocal<String> handler = new ThreadLocal<>();

    public void login(String name) {
        handler.set(name);
    }

    public static String getCurrentName() {
        return handler.get();
    }
}
