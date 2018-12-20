package com.training.web.controller.impl;

import com.training.User;
import com.training.web.controller.AbstractCrudController;
import com.training.web.model.UserIDto;
import com.training.web.service.ICrudService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController extends AbstractCrudController<User, UserIDto> {

    public UserController(ICrudService<User, UserIDto> service) {
        super(service);
    }
}
