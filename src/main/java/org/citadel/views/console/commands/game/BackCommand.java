package org.citadel.views.console.commands.game;

import org.citadel.common.tools.Terminal;
import org.citadel.views.console.commands.Command;
import org.citadel.views.console.menus.Menu;
import org.citadel.views.console.menus.MenuContext;

public class BackCommand implements Command {

    private final MenuContext menuContext;

    public BackCommand(MenuContext menuContext) {
        super();
        this.menuContext = menuContext;
    }

    @Override
    public void execute() {
        context.back();
    }
}