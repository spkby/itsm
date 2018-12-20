package com.training.menu.transaction;

import com.training.menu.AbstractMenu;
import com.training.menu.IMenuItem;
import com.training.menu.TopLevelMenu;
import com.training.menu.util.MenuHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@TopLevelMenu
public class TransactionTopMenu extends AbstractMenu implements IMenuItem {

    @Autowired
    public TransactionTopMenu(@TransactionMenuItem List<IMenuItem> topLevelItems, MenuHelper menuHelper) {
        super(topLevelItems, menuHelper);
    }

    @Override
    public String getTitle() {
        return "Transactions";
    }

    @Override
    public int doAction() {
        run();
        return 0;
    }
}
