package com.training.service.impl;

import com.training.dto.EntityUserDao;
import com.training.User;
import com.training.service.EntityUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements EntityUserService {

    private final EntityUserDao userDao;

    @Autowired
    public UserServiceImpl(EntityUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getRegister(User user) {
        userDao.getRegister(user);
    }

    @Override
    public User getActiveUser(String name, String password) {

        return userDao.getActiveUser(name, password);
    }

}
