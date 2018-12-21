package by.itsm.patients.console.menu.state;

import by.itsm.patients.common.entity.State;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.logic.service.domain.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Component
@StateMenuItem
public class RandomStateMenuItem implements IMenuItem {

    @Autowired
    private IStateService stateService;

    @Override
    public String getTitle() {
        return "Print random state";
    }

    @Override
    @Transactional
    public int doAction() {
        List<State> all = stateService.findAll();
        int randomIndex = new Random().nextInt(all.size());
        State state = all.get(randomIndex);
        System.out.println(state);
        return 0;
    }
}
