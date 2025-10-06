package org.citadel.views.console.commands.game;

import org.citadel.views.console.commands.Command;
import org.citadel.views.console.menus.MenuContext;

public class BackCommand implements Command {

    private final MenuContext menuContext;

    public BackCommand(MenuContext menuContext) {
        super();
        this.menuContext = menuContext;
    }

    @Override
    public void execute() {
        menuContext.back();
    }
}