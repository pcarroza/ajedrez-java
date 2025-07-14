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
import static org.citadel.models.pieces.Color.BLACK;
import static org.citadel.models.pieces.Color.WHITE;
import static org.citadel.models.pieces.PiecesMapBuilder.*;

public class Board extends SubjectBoard implements ObserverBoard {

    private final Map<Color, List<Piece>> piecesMap;

    private final Map<Color, List<Piece>> mapOfRemovedPieces;

    private final Map<Color, List<Piece>> mapPassantPawns;

    private List<Coordinate> movementsSelectedPiece;

    private SelectedPiece selectedPiece;

    private final Turn turn;

    public Board() {
        piecesMap = createPiecesMap(this);
        turn = new Turn();
        mapOfRemovedPieces = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
        movementsSelectedPiece = Collections.emptyList();
        mapPassantPawns = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
    }

    @Override
    public void set(List<Coordinate> movementsSelectedPiece) {
        this.movementsSelectedPiece = movementsSelectedPiece;
    }

    @Override
    public void set(Piece passantPawns) {
        assert passantPawns != null;
        mapPassantPawns.get(getCurrentPlayer()).add(passantPawns);
    }

    public List<Coordinate> getMovementsSelectedPiece() {
        assert movementsSelectedPiece != null;
        return List.copyOf(movementsSelectedPiece);
    }

    public void selectPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isWithinBoardLimits(coordinate);
        assert !isBoxEmpty(coordinate);
        getPiecesBy(getCurrentPlayer())
                .filter(piece -> piece.has(coordinate))
                .findFirst()
                .ifPresentOrElse(piece -> {
                    piece.buildMovements();
                    this.set(piece.getValidMovements());
                    this.selectedPiece = piece;
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
        assert isWithinBoardLimits(coordinate);
        remove(this::getCurrentPlayer, coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isWithinBoardLimits(coordinate);
        remove(this::getRivalPlayer, coordinate);
    }

    private void remove(Supplier<Color> color, Coordinate coordinate) {
        assert coordinate != null;
        assert isWithinBoardLimits(coordinate);
        piecesMap.get(color.get()).removeIf(piece -> {
            if (piece.has(coordinate)) {
                return mapOfRemovedPieces.get(color.get()).add(piece);
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
        return getPiecesBy(getCurrentPlayer()).anyMatch(piece -> piece.has(coordinate));
    }

    public boolean isTheWhitePieceSelected(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(WHITE).anyMatch(piece -> piece.has(coordinate));
    }

    public boolean isTheBlackPieceSelected(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(BLACK).anyMatch(piece -> piece.has(coordinate));
    }

    @Override
    public boolean isItEnemy(Coordinate coordinate) {
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
        return movementsSelectedPiece.contains(piece.getCoordinate()) && piece.isKing();
    }

    public boolean isRook(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getCurrentPlayer()).filter(piece -> piece.has(coordinate)).anyMatch(Piece::isRook);
    }

    private Stream<Piece> getPiecesBy(Color color) {
        return piecesMap.get(color).stream();
    }

    public boolean isBoxEmpty(Coordinate coordinate) {
        assert coordinate != null;
        return piecesMap.values().stream()
                .noneMatch(pieces -> pieces.stream().anyMatch(piece -> piece.has(coordinate)));
    }

    public int getIndexCurrentPlayer() {
        return turn.getIndexCurrentPlayer();
    }

    public Color getCurrentPlayer() {
        return turn.getColor();
    }

    public Color getRivalPlayer() {
        Turn clone = turn.copy();
        clone.change();
        return clone.getColor();
    }

    public void changeTurn() {
        turn.change();
    }

    public boolean finished() {
        return true;
    }

    public static void main(String[] args) {

        Board board = new Board();
        writeln("" + board.isBoxEmpty(new Coordinate(3, 1)));
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
                System.out.println(board.getMovementsSelectedPiece());
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