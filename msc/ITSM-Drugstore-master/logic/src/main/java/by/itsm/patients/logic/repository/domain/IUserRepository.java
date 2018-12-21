package by.itsm.patients.logic.repository.domain;

import by.itsm.patients.common.entity.User;
import by.itsm.patients.logic.repository.ICrudRepository;

public interface IUserRepository extends ICrudRepository<User> {

    User loggedUser(String name, String password);

}
