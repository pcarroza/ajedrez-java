package org.citadel.models;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.citadel.common.tools.Terminal.input;
import static org.citadel.common.tools.Terminal.writeln;
import static org.citadel.models.pieces.Player.BLACK;
import static org.citadel.models.pieces.Player.WHITE;
import static org.citadel.models.pieces.PiecesMapBuilder.*;

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
    public void set(List<Coordinate> movementsSelectedPiece) {
        this.selectedPieceMovements = movementsSelectedPiece;
    }

    @Override
    public void add(Piece enPassantPawn) {
        assert enPassantPawn != null;
        enPassantPawnsMap.get(getCurrentPlayer()).add(enPassantPawn);
    }

    public List<Coordinate> getSelectedPieceMovements() {
        assert selectedPieceMovements != null;
        return List.copyOf(selectedPieceMovements);
    }

    public void selectPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isWithinBoardLimits(coordinate);
        assert !isSquareEmpty(coordinate);
        getPiecesBy(getCurrentPlayer())
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .ifPresentOrElse(piece -> {
                    piece.generateMovements();
                    set(piece.getValidMovements());
                    selectedPiece = piece;
                }, () -> {
                    assert false;
                });
    }

    public boolean isSelectedPiece() {
        return selectedPiece != null;
    }

    public void clearSelectedPiece() {
        selectedPiece = null;
    }

    public void putSelectedPieceInThis(Coordinate coordinate) {
        assert coordinate != null;
        assert selectedPiece != null;
        assert isWithinBoardLimits(coordinate);
        selectedPiece.put(coordinate);
    }

    public boolean isThePawnPromoted() {
        return selectedPiece.isThePawnPromoted();
    }

    public boolean isMovementValid(Coordinate coordinate) {
        assert coordinate != null;
        assert selectedPiece != null;
        assert isWithinBoardLimits(coordinate);
        return selectedPiece.isMovementValid(coordinate);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert !isSquareEmpty(coordinate);
        assert isWithinBoardLimits(coordinate);
        remove(this::getCurrentPlayer, coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert !isSquareEmpty(coordinate);
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
    public boolean someColor(Coordinate coordinate) {
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

    public boolean isSquareEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return piecesMap.values().stream()
                .noneMatch(pieces -> pieces.stream().anyMatch(piece -> piece.isAt(coordinate)));
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

    public void changeTurn() {
        turn.change();
    }

    public boolean finished() {
        return true;
    }

    public static void main(String[] args) {

        Board board = new Board();
        writeln("" + board.isSquareEmpty(new Coordinate(3, 1)));
        do {
            boolean isSelected;
            do {
                writeln("SELECCIONAR PIEZA DEL JUGADO " + board.getCurrentPlayer());

                writeln("INGRESE ROW: ");
                int row = input(Integer.class);

                writeln("INGRESE COLUMNA: ");
                int column = input(Integer.class);

                isSelected = board.isPieceSelected(new Coordinate(row, column));
                writeln("" + isSelected);
                System.out.println(board.getSelectedPieceMovements());
                if (isSelected) {
                    board.selectPiece(new Coordinate(row, column));
                }

            } while (!isSelected);

            board.changeTurn();

            do {
                writeln("MOVER PIEZA " + board.getCurrentPlayer());

                writeln("INGRESE ROW: ");
                int row = input(Integer.class);

                writeln("INGRESE COLUMNA: ");
                int column = input(Integer.class);

                Coordinate coordinate = new Coordinate(row, column);

                if (board.isMovementValid(coordinate)) {
                    board.putSelectedPieceInThis(coordinate);
                    break;
                }

                writeln("Movimiento inválido. Inténtalo de nuevo.");
            } while (true);

        } while (true);
    }
}