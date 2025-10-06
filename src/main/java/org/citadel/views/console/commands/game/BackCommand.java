package org.citadel.views.console.commands.game;

import org.citadel.common.tools.Terminal;
import org.citadel.views.console.commands.Command;
import org.citadel.views.console.menus.Menu;
import org.citadel.views.console.menus.MenuContext;

public class BackCommand implements Command {

    private final MenuContext context;

    public BackCommand(MenuContext context) {
        super();
        this.context = context;
    }

    @Override
    public void execute() {
        Menu current = context.getCurrentMenu();
        if (current != null && current.getParent() != null) {
            context.setCurrentMenu(current.getParent());
            Terminal.writeln("⬅️ Volviendo a " + current.getParent().getTitle());
        } else {
            Terminal.writeln("⚠️ Ya estás en el menú principal.");
        }
    }
}