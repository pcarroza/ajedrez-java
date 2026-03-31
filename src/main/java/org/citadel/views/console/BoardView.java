package org.citadel.views.console;

import org.citadel.common.tools.Terminal;
import org.citadel.controllers.PlacementController;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.enums.Player;

public class BoardView {

    public void write(PlacementController controller) {
        Terminal.writeln("  a b c d e f g h");
        for (int i = 7; i >= 0; i--) {
            Terminal.write((i + 1) + " ");
            for (int j = 0; j < 8; j++) {
                String pieceChar = controller.getPieceChar(new Coordinate(i, j));
                Terminal.write(pieceChar + " ");
            }
            Terminal.writeln("" + (i + 1));
        }
        Terminal.writeln("  a b c d e f g h");
    }

    public void write(Player player) {
        Terminal.writeln("Turno de: " + player);
    }
}



