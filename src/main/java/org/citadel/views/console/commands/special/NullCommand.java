package org.citadel.views.console.commands.special;

import org.citadel.views.console.commands.Command;

public class NullCommand extends Command {

    public NullCommand() {
        super("Ninguno");
    }

    @Override
    public void execute() {
        // Do nothing
    }
}
