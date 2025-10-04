package org.citadel.views.console.menus.commands.special;

import org.citadel.controllers.CastlingMovesController;
import org.citadel.views.console.menus.commands.Command;
import org.citadel.models.pieces.Coordinate;
import org.citadel.common.tools.Terminal;

import java.util.List;

public class CastlingMoveCommand extends Command {

    private final CastlingMovesController controller;

    public CastlingMoveCommand(CastlingMovesController controller) {
        super("Enroque");
        this.controller = controller;
    }

    @Override
    public void execute() {
        Terminal.writeln("Has elegido Enroque.");
        List<Coordinate> rooks = controller.getAvailableRooks();
        Terminal.writeln("TODO: Implementar la selección de la torre.");
    }
}
