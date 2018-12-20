package com.itsm.pub.courses.patients.front.menu.state;

import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.menu.IMenuItem;
import com.itsm.pub.courses.patients.front.repository.domain.impl.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Component
@StateMenuItem
public class RandomStateMenuItem implements IMenuItem {

    private final StateRepository stateRepository;

    @Autowired
    public RandomStateMenuItem(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public String getTitle() {
        return "Print random state";
    }

    @Override
    @Transactional
    public int doAction() {
        List<State> all = stateRepository.findAll();
        int randomIndex = new Random().nextInt(all.size());
        State state = all.get(randomIndex);
        System.out.println(state);
        return 0;
    }
}
