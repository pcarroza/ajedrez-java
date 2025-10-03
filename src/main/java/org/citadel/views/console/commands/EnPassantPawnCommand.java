package org.citadel.views.console.commands;

import org.citadel.common.tools.Terminal;
import org.citadel.controllers.EnPassantPawnController;

public class EnPassantPawnCommand extends Command {
    private final EnPassantPawnController controller;

    public EnPassantPawnCommand(EnPassantPawnController controller) {
        super("Captura al Paso");
        this.controller = controller;
    }

    @Override
    public void execute() {
        Terminal.writeln("Has elegido Captura al Paso.");
        boolean confirm = Terminal.readString("¿Confirmar? (s/n): ").equalsIgnoreCase("s");
        if (confirm) {
            controller.capture();
        }
    }
}
