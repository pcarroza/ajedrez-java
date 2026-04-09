package org.citadel.views.console;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.PieceSimbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.controllers.modules.game.GameController;

import java.util.List;

import static org.citadel.common.tools.Terminal.*;

public class BoardView {

    private final GameController gameController;

    public BoardView(GameController gameController) {
        this.gameController = gameController;
    }

    public void render() {
        clear();
        printBoard();
    }

    public void printBoard() {
        writeln("\n    a b c d e f g h");
        writeln("  +-----------------+");

        for (int row = 8; row >= 1; row--) {
            write(row + " | ");

            for (int col = 1; col <= 8; col++) {
                PieceSimbol symbol = gameController.getPieceSymbol(new Coordinate(row, col));
                String symbolText = symbol == PieceSimbol.EMPTY ? "." : symbol.getValue();
                write(symbolText + " ");
            }

            writeln("| " + row);
        }

        writeln("  +-----------------+");
        writeln("    a b c d e f g h\n");
    }

    public void showTurn(Player player) {
        writeln("\nTURNO DE: " + player);
    }

    public void showSelectedPiece(PieceSimbol symbol, List<Coordinate> moves) {
        writeln("Pieza seleccionada: " + symbol);
        writeln("Movimientos posibles: " + moves);
    }

    public void showPromotion() {
        writeln("¡PROMOCIÓN! El peón ha alcanzado el final.");
    }

    public void showCheck(Player rivalPlayer) {
        writeln("¡ATENCIÓN! El Rey del jugador " + rivalPlayer + " está en JAQUE.");
    }

    public void showCapture(String symbol) {
        writeln("¡Captura! Has comido la pieza " + symbol);
    }

    public void showEnPassant() {
        writeln("¡Captura al paso!");
    }

    public void showCastling() {
        writeln("¡Enroque!");
    }

    public void showMoveCompleted(Coordinate target) {
        writeln("Movimiento completado a " + target);
    }

    public void showError(String message) {
        writeln("Error: " + message);
    }
}