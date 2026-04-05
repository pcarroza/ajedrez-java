package org.citadel.views.console;

import org.citadel.models.modules.game.pieces.Coordinate;

import static org.citadel.common.tools.Terminal.*;

public class InputView {

    public Coordinate askCoordinate(String colMsg, String rowMsg) {
        int column = askColumn(colMsg);
        int row = askRow(rowMsg);
        return new Coordinate(row, column);
    }

    public Coordinate askDestinationOrCancel(String colMsg) {
        int column = askColumn(colMsg);
        write("Fila destino (1-8): ");
        int row = input(Integer.class);
        if (row == 0)
            return null;
        return new Coordinate(row, column);
    }

    public String askPromotionChoice() {
        String choice;
        do {
            write("Elija pieza (Q: Reina, T: Torre, B: Alfil, C: Caballo): ");
            choice = input(String.class).trim().toUpperCase();
            if (!choice.matches("[QTBC]"))
                writeln("Opción inválida. Use Q, T, B o C.");
        } while (!choice.matches("[QTBC]"));
        return choice;
    }

    private int askRow(String message) {
        int val;
        do {
            write(message);
            val = input(Integer.class);
            if (val < 1 || val > 8)
                writeln("Valor inválido. Ingrese un número entre 1 y 8.");
        } while (val < 1 || val > 8);
        return val;
    }

    private int askColumn(String message) {
        int column = -1;
        do {
            write(message);
            String raw = input(String.class).trim().toLowerCase();
            if (raw.length() == 1) {
                char c = raw.charAt(0);
                if (c >= 'a' && c <= 'h')
                    column = c - 'a' + 1;
                else if (c >= '1' && c <= '8')
                    column = c - '1' + 1;
            }
            if (column == -1)
                writeln("Valor inválido. Use letras de 'a' a 'h' o números del 1 al 8.");
        } while (column == -1);
        return column;
    }
}