package com.training.menu.state.action;

import com.training.State;
import com.training.menu.IMenuItem;
import com.training.menu.state.StateMenuItem;
import com.training.service.EntityListIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StateMenuItem
public class StateListMenuItem implements IMenuItem {

    private final EntityListIdService<State> stateService;

    @Autowired
    public StateListMenuItem(EntityListIdService<State> stateService) {
        this.stateService = stateService;
    }

    @Override
    public String getTitle() {
        return "Print all list";
    }

    @Override
    public int doAction() {
        stateService.getAll().forEach(System.out::println);
        return 0;
    }
}
