package com.training.menu;

import com.training.menu.util.MenuHelper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MainMenu extends AbstractMenu {
    public MainMenu(@TopLevelMenu List<IMenuItem> topLevelItems, MenuHelper menuHelper) {
        super(topLevelItems, menuHelper);
    }
}
