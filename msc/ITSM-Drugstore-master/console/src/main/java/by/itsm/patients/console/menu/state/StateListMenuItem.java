package by.itsm.patients.console.menu.state;

import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.logic.service.domain.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@StateMenuItem
public class StateListMenuItem implements IMenuItem {

    @Autowired
    private IStateService stateService;

    @Override
    public String getTitle() {
        return "Print state list";
    }

    @Override
    public int doAction() {
        stateService.findAll().forEach(System.out::println);
        return 0;
    }
}
