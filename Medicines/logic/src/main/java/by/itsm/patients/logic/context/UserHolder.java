package by.itsm.patients.logic.context;

import by.itsm.patients.common.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserHolder {

    private static ThreadLocal<User> handler = new ThreadLocal<>();

    public void login(User user) {
        handler.set(user);
    }

    public static User getCurrentUser() {
        return handler.get();
    }
}

