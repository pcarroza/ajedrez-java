package org.citadel.views.console.menus.commands.special;

import org.citadel.common.tools.Terminal;
import org.citadel.controllers.PromotionPawnController;
import org.citadel.views.console.menus.commands.Command;

public class PromotionPawnCommand extends Command {
    private final PromotionPawnController controller;

    public PromotionPawnCommand(PromotionPawnController controller) {
        super("Promoción de Peón");
        this.controller = controller;
    }

    @Override
    public void execute() {
        Terminal.writeln("Has elegido Promoción de Peón.");
        String pieceType = Terminal.readString("Elige pieza (Q, R, B, K): ");
        controller.promote(pieceType);
    }
}
