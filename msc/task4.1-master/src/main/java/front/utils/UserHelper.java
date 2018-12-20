package front.utils;

import front.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserHelper implements IUserHelper {

    public static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserHelper.currentUser = currentUser;
    }
}
