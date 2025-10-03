package org.citadel.views.console.commands;

public class NullCommand extends Command {

    public NullCommand() {
        super("Ninguno");
    }

    @Override
    public void execute() {
        // Do nothing
    }
}
