package front.DAO.impl;

import front.DAO.ICreateUpdateOperations;
import front.models.User;

public interface IUserDAO extends ICreateUpdateOperations<User> {

    void create(User user);
    User find(Integer id);
    boolean verifyUserByLoginAndPassword(String login, String password);
}
