package by.itsm.patients.logic.service.domain;

import by.itsm.patients.common.entity.User;
import by.itsm.patients.logic.service.ICrudService;

public interface IUserService extends ICrudService<User> {

    User loggedUser(String name, String password);

}
