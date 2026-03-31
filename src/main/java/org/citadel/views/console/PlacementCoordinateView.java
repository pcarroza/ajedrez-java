package org.citadel.views.console;

import org.citadel.common.tools.Terminal;
import org.citadel.models.modules.game.pieces.Coordinate;

public class PlacementCoordinateView {

    public Coordinate getCoordinate(String message) {
        Terminal.writeln("Introduce la coordenada para " + message);
        int row = Terminal.readInt("Fila (0-7): ");
        int column = Terminal.readInt("Columna (0-7): ");
        return new Coordinate(row, column);
    }

    public void showError(String message) {
        Terminal.writeln("Error: " + message);
    }
}