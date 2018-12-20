package com.training.context;

import com.training.User;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

    private static final ThreadLocal<User> threadLocal = new ThreadLocal<>();

    public String getName() {
        return threadLocal.get().getLogin();
    }

    public User getUser() {
        return threadLocal.get();
    }

    public void setUser(User user) {
        threadLocal.set(user);
    }

}
