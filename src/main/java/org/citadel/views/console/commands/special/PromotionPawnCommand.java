package org.citadel.views.console.commands.special;

import org.citadel.common.tools.Terminal;
import org.citadel.controllers.modules.game.PromotionPawnController;
import org.citadel.views.console.commands.Command;

public class PromotionPawnCommand implements Command {
    private final PromotionPawnController controller;

    public PromotionPawnCommand(PromotionPawnController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        Terminal.writeln("Has elegido Promoción de Peón.");
        String pieceType = Terminal.readString("Elige pieza (Q, R, B, K): ");
        controller.promote(pieceType);
    }
}
