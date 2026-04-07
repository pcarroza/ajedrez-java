package org.citadel.models.modules.game;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.SelectedPiece;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.enums.PromotionType;
import org.citadel.models.modules.game.pieces.visitors.PieceInspector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.citadel.models.modules.game.pieces.PiecesMapBuilder.createPiecesMap;
import static org.citadel.models.modules.game.pieces.enums.Player.BLACK;
import static org.citadel.models.modules.game.pieces.enums.Player.WHITE;

public class Board extends SubjectBoard implements BoardObserver {

    private final Map<Player, List<Piece>> piecesMap;

    private final Map<Player, List<Piece>> removedPieces;

    private final Map<Player, List<Piece>> pawnMapInStep;

    private List<Coordinate> selectedPieceMovements;

    private SelectedPiece selectedPiece;

    private final Turn turn;

    public Board() {
        piecesMap = createPiecesMap(this);
        removedPieces = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
        pawnMapInStep = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
        selectedPieceMovements = Collections.emptyList();
        turn = new Turn();
    }

    @Override
    public void set(List<Coordinate> selectedPieceMovements) {
        this.selectedPieceMovements = selectedPieceMovements;
    }

    public List<Coordinate> getSelectedPieceMovements() {
        assert selectedPieceMovements != null;
        return List.copyOf(selectedPieceMovements);
    }

    public String getPieceSymbol(Coordinate coordinate) {
        assert coordinate != null : "Board: 56: Coordinate cannot be null";
        return piecesMap.values().stream()
                .flatMap(List::stream)
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .map(PieceInspector::getPieceSymbol)
                .orElse("");
    }

    public void selectPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isWithinBoardLimits(coordinate);
        assert isOccupied(coordinate);
        assert belongsToCurrentPlayer(coordinate);
        getPiecesBy(getCurrentPlayer())
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .ifPresentOrElse(piece -> {
                    piece.generateMovements();
                    set(piece.getMovements());
                    selectedPiece = piece;
                }, () -> {
                    assert false : "Board: 77: Selected piece not found";
                });
    }

    public void putPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert selectedPiece != null;
        assert isWithinBoardLimits(coordinate);
        assert !belongsToCurrentPlayer(coordinate);
        selectedPiece.put(coordinate);
    }

    public boolean belongsToCurrentPlayer(Coordinate coordinate) {
        assert coordinate != null;
        return isOccupied(coordinate) && isPieceSamePlayerAt(coordinate);
    }

    public void relocate(Coordinate origin, Coordinate target) {
        assert origin != null;
        assert target != null;
        assert isWithinBoardLimits(origin);
        assert isWithinBoardLimits(target);
        assert isOccupied(origin);
        piecesMap.values().stream()
                .flatMap(List::stream)
                .filter(piece -> piece.isAt(origin))
                .findFirst()
                .ifPresent(piece -> piece.put(target));
    }

    public void promote(PromotionType promotionType) {
        assert selectedPiece != null;
        assert PieceInspector.isPawn((Piece) selectedPiece);
        Coordinate coordinate = selectedPiece.getCoordinate();
        Player player = getCurrentPlayer();
        Piece newPiece = promotionType.createPromotedPiece(coordinate, player);
        newPiece.subscribe(this);
        piecesMap.get(player).remove((Piece) selectedPiece);
        piecesMap.get(player).add(newPiece);
        selectedPiece = newPiece;
    }

    @Override
    public void add(Piece inStepPawn) {
        assert inStepPawn != null;
        pawnMapInStep.get(getCurrentPlayer()).add(inStepPawn);
    }

    @Override
    public void remove(Piece inStepPawn) {
        assert inStepPawn != null;
        pawnMapInStep.get(getCurrentPlayer()).remove(inStepPawn);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isOccupied(coordinate);
        assert isWithinBoardLimits(coordinate);
        remove(this::getCurrentPlayer, coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isOccupied(coordinate);
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

    public boolean isKingClaimed() {
        return selectedPiece != null && PieceInspector.isKing((Piece) selectedPiece);
    }

    public boolean isPawnClaimed() {
        return selectedPiece != null && PieceInspector.isPawn((Piece) selectedPiece);
    }

    public List<Coordinate> getSelectedPieceEnPassantDiagonals() {
        assert selectedPiece != null;
        return PieceInspector.getEnPassantDiagonals((Piece) selectedPiece);
    }

    public Coordinate getSelectedPieceCoordinate() {
        assert selectedPiece != null;
        return selectedPiece.getCoordinate();
    }

    public boolean hasPieceClaimed() {
        return selectedPiece != null;
    }

    public void resetSelectedPiece() {
        selectedPiece = null;
    }

    public boolean isThePawnPromoted() {
        return PieceInspector.isPawnPromoted((Piece) selectedPiece);
    }

    public boolean canReach(Coordinate coordinate) {
        assert coordinate != null;
        assert selectedPiece != null;
        assert isWithinBoardLimits(coordinate);
        return selectedPiece.isMovementValid(coordinate);
    }

    public boolean isOccupied(Coordinate coordinate) {
        assert coordinate != null;
        return piecesMap.values().stream().flatMap(List::stream).anyMatch(piece -> piece.isAt(coordinate));
    }

    @Override
    public boolean isRival(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getRivalPlayer()).map(Piece::getCoordinate).toList().contains(coordinate);
    }

    public boolean isWithinBoardLimits(Coordinate coordinate) {
        assert coordinate != null;
        return ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
    }

    public boolean hasClaimed(Coordinate coordinate) {
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
    public boolean isPieceSamePlayerAt(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getCurrentPlayer()).map(Piece::getCoordinate).toList().contains(coordinate);
    }

    @Override
    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        return pawnMapInStep.get(getRivalPlayer()).stream().anyMatch(p -> p.isAt(coordinate));
    }

    public boolean isCheck() {
        return getPiecesBy(getRivalPlayer()).anyMatch(this::isTheKingInValidMoves);
    }

    private boolean isTheKingInValidMoves(Piece piece) {
        assert piece != null;
        return selectedPieceMovements.contains(piece.getCoordinate()) && PieceInspector.isKing(piece);
    }

    @Override
    public boolean isRookAvailableForCastling(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getCurrentPlayer())
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .map(PieceInspector::isRookAvailableForCastling)
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

    public void endTurn() {
        turn.switchTurn();
        pawnMapInStep.get(getCurrentPlayer()).clear();
    }

    public boolean finished() {
        return false;
    }
}
