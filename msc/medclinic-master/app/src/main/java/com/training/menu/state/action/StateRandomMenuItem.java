package com.training.menu.state.action;

import com.training.State;
import com.training.menu.IMenuItem;
import com.training.menu.state.StateMenuItem;
import com.training.service.EntityListIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Component
@StateMenuItem
public class StateRandomMenuItem implements IMenuItem {

    private final EntityListIdService<State> stateService;

    @Autowired
    public StateRandomMenuItem(EntityListIdService<State> stateService) {
        this.stateService = stateService;
    }

    @Override
    public String getTitle() {
        return "Print random states";
    }

    @Override
    @Transactional
    public int doAction() {
        List<State> all = stateService.getAll();
        int randomIndex = new Random().nextInt(all.size());
        State state = all.get(randomIndex);
        System.out.println(state);
        return 0;
    }
}
