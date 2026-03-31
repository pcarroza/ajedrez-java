package org.citadel.views.console.commands.special;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.views.console.commands.Command;
import org.citadel.common.tools.Terminal;
import org.citadel.controllers.modules.game.CastlingMovesController;

import java.util.List;

public class CastlingMoveCommand implements Command {

    private final CastlingMovesController controller;

    public CastlingMoveCommand(CastlingMovesController controller) {
        this.controller = controller;
    }

    @Override
    public void execute() {
        Terminal.writeln("Has elegido Enroque.");
        List<Coordinate> rooks = controller.getAvailableRooks();
        Terminal.writeln("TODO: Implementar la selección de la torre.");
    }
}
