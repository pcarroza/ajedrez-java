package org.citadel.controllers.modules.game.local;

import static org.citadel.common.tools.Terminal.input;
import static org.citadel.common.tools.Terminal.write;
import static org.citadel.common.tools.Terminal.writeln;

import org.citadel.models.modules.game.pieces.Coordinate;

public class LocalInputController {

    public class InputController {

        public Coordinate readCoordinate(String colMsg, String rowMsg) {
            int col = readColumn(colMsg);
            int row = readRow(rowMsg);
            return new Coordinate(row, col);
        }

        public Coordinate readDestinationOrCancel(String colMsg) {
            int col = readColumn(colMsg);
            write("Fila destino (1-8): ");
            int row = input(Integer.class);
            if (row == 0)
                return null;
            return new Coordinate(row, col);
        }

        public String readPromotionChoice() {
            String choice;
            do {
                write("Elija pieza (Q: Reina, T: Torre, B: Alfil, C: Caballo): ");
                choice = input(String.class).trim().toUpperCase();
                if (!choice.matches("[QTBC]"))
                    writeln("Opción inválida. Use Q, T, B o C.");
            } while (!choice.matches("[QTBC]"));
            return choice;
        }

        private int readRow(String message) {
            int val;
            do {
                write(message);
                val = input(Integer.class);
                if (val < 1 || val > 8)
                    writeln("Valor inválido. Ingrese un número entre 1 y 8.");
            } while (val < 1 || val > 8);
            return val;
        }

        private int readColumn(String message) {
            int col = -1;
            do {
                write(message);
                String raw = input(String.class).trim().toLowerCase();
                if (raw.length() == 1) {
                    char c = raw.charAt(0);
                    if (c >= 'a' && c <= 'h')
                        col = c - 'a' + 1;
                    else if (c >= '1' && c <= '8')
                        col = c - '1' + 1;
                }
                if (col == -1)
                    writeln("Valor inválido. Use letras de 'a' a 'h' o números del 1 al 8.");
            } while (col == -1);
            return col;
        }
    }
}