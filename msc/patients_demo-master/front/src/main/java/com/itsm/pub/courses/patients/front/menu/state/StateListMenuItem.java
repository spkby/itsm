package com.itsm.pub.courses.patients.front.menu.state;

import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.repository.domain.impl.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StateMenuItem
public class StateListMenuItem implements IMenuItem {

    private final StateRepository stateRepository;

    @Autowired
    public StateListMenuItem(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public String getTitle() {
        return "Print state list";
    }

    @Override
    public int doAction() {
        stateRepository.findAll().forEach(System.out::println);
        return 0;
    }
}
