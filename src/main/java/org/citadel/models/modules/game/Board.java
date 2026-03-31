package org.citadel.models.modules.game;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.SelectedPiece;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.visitors.PieceInspector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.citadel.common.tools.Terminal.clear;
import static org.citadel.common.tools.Terminal.input;
import static org.citadel.common.tools.Terminal.write;
import static org.citadel.common.tools.Terminal.writeln;
import static org.citadel.models.modules.game.pieces.PiecesMapBuilder.createPiecesMap;
import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;

public class Board extends SubjectBoard implements BoardObserver {

    private final Map<Player, List<Piece>> piecesMap;

    private final Map<Player, List<Piece>> removedPieces;

    private final Map<Player, List<Piece>> enPassantPawnsMap;

    private List<Coordinate> selectedPieceMovements;

    private SelectedPiece selectedPiece;

    private final Turn turn;

    public Board() {
        piecesMap = createPiecesMap(this);
        removedPieces = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
        enPassantPawnsMap = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
        selectedPieceMovements = Collections.emptyList();
        turn = new Turn();
    }

    @Override
    public void set(List<Coordinate> selectedPieceMovements) {
        this.selectedPieceMovements = selectedPieceMovements;
    }

    @Override
    public void add(Piece enPassantPawn) {
        assert enPassantPawn != null;
        enPassantPawnsMap.get(getCurrentPlayer()).add(enPassantPawn);
    }

    @Override
    public void remove(Piece enPassantPawn) {
        assert enPassantPawn != null;
        enPassantPawnsMap.get(getCurrentPlayer()).remove(enPassantPawn);
    }

    public List<Coordinate> getSelectedPieceMovements() {
        assert selectedPieceMovements != null;
        return List.copyOf(selectedPieceMovements);
    }

    public String getPieceSymbol(Coordinate coordinate) {
        return piecesMap.values().stream()
                .flatMap(List::stream)
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .map(PieceInspector::getPieceSymbol)
                .orElse(" ");
    }

    public void selectPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isWithinBoardLimits(coordinate);
        assert isSquareOccupied(coordinate);
        getPiecesBy(getCurrentPlayer())
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .ifPresentOrElse(piece -> {
                    piece.generateMovements();
                    set(piece.getMovements());
                    selectedPiece = piece;
                }, () -> {
                    assert false;
                });
    }

    public void putPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert selectedPiece != null;
        assert isWithinBoardLimits(coordinate);
        selectedPiece.put(coordinate);
    }

    public boolean isSelectedPiece() {
        return selectedPiece != null;
    }

    public void resetSelectedPiece() {
        selectedPiece = null;
    }

    public boolean isThePawnPromoted() {
        return PieceInspector.isPawnPromoted((Piece) selectedPiece);
    }

    public boolean isMovementValid(Coordinate coordinate) {
        assert coordinate != null;
        assert selectedPiece != null;
        assert isWithinBoardLimits(coordinate);
        return selectedPiece.isMovementValid(coordinate);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isSquareOccupied(coordinate);
        assert isWithinBoardLimits(coordinate);
        remove(this::getCurrentPlayer, coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isSquareOccupied(coordinate);
        assert isWithinBoardLimits(coordinate);
        remove(this::getRivalPlayer, coordinate);
    }

    private void remove(Supplier<Player> color, Coordinate coordinate) {
        piecesMap.get(color.get()).removeIf(piece -> {
            if (piece.isAt(coordinate)) {
                return removedPieces.get(color.get()).add(piece);
            }
            return false;
        });
    }

    public boolean isSquareOccupied(Coordinate coordinate) {
        assert coordinate != null;
        return piecesMap.values().stream().flatMap(List::stream).anyMatch(piece -> piece.isAt(coordinate));
    }

    public boolean isWithinBoardLimits(Coordinate coordinate) {
        assert coordinate != null;
        return ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
    }

    public boolean isPieceSelected(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getCurrentPlayer()).anyMatch(piece -> piece.isAt(coordinate));
    }

    public boolean isTheWhitePieceSelected(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(WHITE).anyMatch(piece -> piece.isAt(coordinate));
    }

    public boolean isTheBlackPieceSelected(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(BLACK).anyMatch(piece -> piece.isAt(coordinate));
    }

    @Override
    public boolean isEnemy(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getRivalPlayer()).map(Piece::getCoordinate).toList().contains(coordinate);
    }

    @Override
    public boolean isOwnPieceAt(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getCurrentPlayer()).map(Piece::getCoordinate).toList().contains(coordinate);
    }

    public boolean isJaque() {
        return getPiecesBy(getRivalPlayer()).anyMatch(this::isTheKingInValidMoves);
    }

    private boolean isTheKingInValidMoves(Piece piece) {
        assert piece != null;
        return selectedPieceMovements.contains(piece.getCoordinate()) && PieceInspector.isKing(piece);
    }

    public boolean isRook(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getCurrentPlayer())
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .map(PieceInspector::isRook)
                .orElse(false);
    }

    private Stream<Piece> getPiecesBy(Player player) {
        return piecesMap.get(player).stream();
    }

    public int getIndexCurrentPlayer() {
        return turn.getIndexCurrentPlayer();
    }

    public Player getCurrentPlayer() {
        return turn.getCurrentPlayer();
    }

    public Player getRivalPlayer() {
        return turn.getRivalPlayer();
    }

    public void switchTurn() {
        turn.switchTurn();
    }

    public boolean finished() {
        return true;
    }

    public void printBoard() {
        writeln("\n    a b c d e f g h");
        writeln("  +-----------------+");
        for (int row = 8; row >= 1; row--) {
            write(row + " | ");
            for (int col = 1; col <= 8; col++) {
                write(getPieceSymbol(new Coordinate(row, col)) + " ");
            }
            writeln("| " + row);
        }
        writeln("  +-----------------+");
        writeln("    a b c d e f g h\n");
    }

    public static void main(String[] args) {
        Board board = new Board();
        writeln("--- INICIO DE PARTIDA DE AJEDREZ ---");

        do {
            clear();
            board.printBoard();
            // --- FASE 1: SELECCIÓN DE ORIGEN ---
            Coordinate origin = null;
            boolean canSelect = false;
            do {
                writeln("\nTURNO DE: " + board.getCurrentPlayer());
                writeln("Seleccione la pieza que desea mover:");

                int row = getValidInput("Fila (1-8): ");
                int colmun = getValidInput("Columna (1-8): ");
                origin = new Coordinate(row, colmun);

                if (!board.isWithinBoardLimits(origin)) {
                    writeln("Error: Coordenada fuera de los límites del tablero.");
                } else if (!board.isSquareOccupied(origin)) {
                    writeln("Error: No hay ninguna pieza en esa posición.");
                } else if (!board.isPieceSelected(origin)) {
                    writeln("Error: Esa pieza no te pertenece.");
                } else {
                    board.selectPiece(origin);
                    if (board.getSelectedPieceMovements().isEmpty()) {
                        writeln("Error: La pieza seleccionada no tiene movimientos legales.");
                    } else {
                        canSelect = true;
                        writeln("Pieza seleccionada: " + board.getPieceSymbol(origin));
                        writeln("Movimientos posibles: " + board.getSelectedPieceMovements());
                    }
                }
            } while (!canSelect);

            // --- FASE 2 Y 3: SELECCIÓN DE DESTINO Y EJECUCIÓN ---
            boolean moveExecuted = false;
            do {
                writeln("\nIndique el destino para " + board.getPieceSymbol(origin) + " en " + origin
                        + " (0 para cancelar selección):");
                int row = input(Integer.class);
                if (row == 0) {
                    board.resetSelectedPiece();
                    break;
                }
                write("Columna (1-8): ");
                int col = input(Integer.class);
                Coordinate target = new Coordinate(row, col);

                if (board.isMovementValid(target)) {
                    if (board.isEnemy(target)) {
                        writeln("¡Captura! Has comido la pieza " + board.getPieceSymbol(target));
                        board.removeRivalPlayerPiece(target);
                    }

                    board.putPiece(target);
                    moveExecuted = true;
                    writeln("Movimiento completado a " + target);

                    if (board.isThePawnPromoted()) {
                        writeln("¡PROMOCIÓN! El peón ha alcanzado el final.");
                    }
                } else {
                    writeln("Error: Movimiento no permitido. Intente otro destino.");
                }
            } while (!moveExecuted);

            if (!moveExecuted)
                continue; // Si canceló selección, vuelve arriba

            // --- FASE 4: EVALUACIÓN POST-JUGADA ---
            if (board.isJaque()) {
                writeln("¡ATENCIÓN! El Rey del jugador " + board.getRivalPlayer() + " está en JAQUE.");
            }

            board.switchTurn();
            board.resetSelectedPiece();

        } while (!board.finished());
    }

    private static int getValidInput(String message) {
        int val;
        do {
            write(message);
            val = input(Integer.class);
            if (val < 1 || val > 8) {
                writeln("Valor inválido. Por favor, introduzca un número entre 1 y 8.");
            }
        } while (val < 1 || val > 8);
        return val;
    }
}