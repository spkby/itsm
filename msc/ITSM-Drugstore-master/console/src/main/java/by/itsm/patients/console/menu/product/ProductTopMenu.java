package by.itsm.patients.console.menu.product;

import by.itsm.patients.console.menu.AbstractMenu;
import by.itsm.patients.console.menu.IMenuItem;
import by.itsm.patients.console.menu.TopLevelMenu;
import by.itsm.patients.console.menu.util.MenuHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@TopLevelMenu
public class ProductTopMenu extends AbstractMenu implements IMenuItem {

    @Autowired
    public ProductTopMenu(@ProductMenuItem List<IMenuItem> topLevelItems, MenuHelper menuHelper) {
        super(topLevelItems, menuHelper);
    }

    @Override
    public String getTitle() {
        return "Product management";
    }

    @Override
    public int doAction() {
        run();
        return 0;
    }
}
