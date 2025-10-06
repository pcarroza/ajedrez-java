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
        Menu current = menuContext.getCurrentMenu();
        if (current != null && current.getParent() != null) {
            menuContext.setCurrentMenu(current.getParent());
            Terminal.writeln("⬅️ Volviendo a " + current.getParent().getTitle());
        } else {
            Terminal.writeln("⚠️ Ya estás en el menú principal.");
        }
    }
}