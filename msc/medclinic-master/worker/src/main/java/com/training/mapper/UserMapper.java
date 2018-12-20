package com.training.mapper;

import com.training.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select id, email, login, created_by, created_at, modified_by, modified_at from users")
    List<User> findAllUsers();

    @Select("select id, email, login, password from users WHERE id=#{id}")
    User getUserById(int id);
}
