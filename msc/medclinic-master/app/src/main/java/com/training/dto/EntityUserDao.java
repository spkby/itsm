package com.training.dto;


import com.training.IEntity;
import com.training.User;

public interface EntityUserDao<T extends IEntity> {
    void getRegister(User user);
    User getActiveUser(String name, String password);
}
