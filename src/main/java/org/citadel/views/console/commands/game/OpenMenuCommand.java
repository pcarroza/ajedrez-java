package org.citadel.views.console.commands.game;

import org.citadel.views.console.commands.Command;
import org.citadel.views.console.menus.Menu;
import org.citadel.views.console.menus.MenuContext;

public class OpenMenuCommand implements Command {

    private final MenuContext context;

    private final Menu menu;

    public OpenMenuCommand(MenuContext context, Menu menu) {
        this.context = context;
        this.menu = menu;
    }

    @Override
    public void execute() {
        context.setCurrentMenu(menu);
    }
}
