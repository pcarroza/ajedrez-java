package org.citadel.views.console.commands.special;

import org.citadel.views.console.commands.Command;

public class NullCommand implements Command {

    public NullCommand() {
        super();
    }

    @Override
    public void execute() {
        // Do nothing
    }
}
