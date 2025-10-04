package org.citadel.views.console.menus.commands.special;

import org.citadel.views.console.menus.commands.Command;

public class NullCommand extends Command {

    public NullCommand() {
        super("Ninguno");
    }

    @Override
    public void execute() {
        // Do nothing
    }
}
