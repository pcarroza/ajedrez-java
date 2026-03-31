package org.citadel.views.console.commands.special;

import org.citadel.common.tools.Terminal;
import org.citadel.controllers.modules.game.EnPassantPawnController;
import org.citadel.views.console.commands.Command;

public class EnPassantPawnCommand implements Command {
    private final EnPassantPawnController controller;

    public EnPassantPawnCommand(EnPassantPawnController controller) {
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
