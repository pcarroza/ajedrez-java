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
        
        if (rooks.isEmpty()) {
            Terminal.writeln("No hay enroques posibles.");
            return;
        }

        Coordinate selectedRook = rooks.get(0);
        if (rooks.size() > 1) {
            Terminal.writeln("Seleccione el tipo de enroque:");
            for (int i = 0; i < rooks.size(); i++) {
                String type = (rooks.get(i).column() == 1) ? "LARGO (Torre en col 1)" : "CORTO (Torre en col 8)";
                Terminal.writeln("[" + (i + 1) + "] " + type);
            }
            int option;
            do {
                option = Terminal.readInt("Elija opción: ");
            } while (option < 1 || option > rooks.size());
            selectedRook = rooks.get(option - 1);
        } else {
            String type = (selectedRook.column() == 1) ? "LARGO" : "CORTO";
            Terminal.writeln("Ejecutando enroque " + type + "...");
        }

        controller.castle(selectedRook);
    }
}
