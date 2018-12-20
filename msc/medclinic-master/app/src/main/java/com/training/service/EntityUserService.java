package com.training.service;

import com.training.IEntity;
import com.training.User;

public interface EntityUserService<T extends IEntity> {
    void getRegister(User user);

    User getActiveUser(String name, String password);
}
