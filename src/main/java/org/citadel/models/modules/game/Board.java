package org.citadel.models.modules.game;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.BoardObserver;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.SelectedPiece;
import org.citadel.models.modules.game.pieces.enums.PieceSymbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.enums.PromotionType;

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

    private final Map<Player, List<SelectedPiece>> piecesMap;

    private final Map<Player, List<SelectedPiece>> removedPieces;

    private final Map<Player, List<SelectedPiece>> pawnMapInStep;

    private SelectedPiece selectedPiece;

    private final Turn turn;

    public Board() {
        piecesMap = createPiecesMap(this);
        removedPieces = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
        pawnMapInStep = Map.of(BLACK, new ArrayList<>(), WHITE, new ArrayList<>());
        turn = new Turn();
    }

    public List<Coordinate> getSelectedPieceMovements() {
        return selectedPiece != null ? selectedPiece.getMovements() : Collections.emptyList();
    }

    public PieceSymbol getPieceSymbol(Coordinate coordinate) {
        assert coordinate != null : "Board: 56: Coordinate cannot be null";
        return piecesMap.values().stream()
                .flatMap(List::stream)
                .filter(piece -> piece.isAt(coordinate))
                .findFirst()
                .map(piece -> piece.getSymbol())
                .orElse(PieceSymbol.EMPTY);
    }

    public void selectPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isWithinBoardLimits(coordinate);
        assert isOccupied(coordinate);
        assert belongsToCurrentPlayer(coordinate);
        getPiecesBy(getCurrentPlayer())
                .filter(selectedPiece -> selectedPiece.isAt(coordinate))
                .findFirst()
                .ifPresentOrElse(selectedPiece -> {
                    selectedPiece.generateMovements();
                    this.selectedPiece = selectedPiece;
                }, () -> {
                    assert false : "Board: Selected piece not found";
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
                .filter(selectedPiece -> selectedPiece.isAt(origin))
                .findFirst()
                .ifPresent(selectedPiece -> selectedPiece.put(target));
    }

    public void promote(PromotionType promotionType) {
        assert selectedPiece != null;
        assert selectedPiece.isPawn();
        Coordinate coordinate = selectedPiece.getCoordinate();
        Player player = getCurrentPlayer();
        Piece newPiece = promotionType.createPromotedPiece(coordinate, player);
        newPiece.subscribe(this);
        piecesMap.get(player).remove(selectedPiece);
        piecesMap.get(player).add(newPiece);
        selectedPiece = newPiece;
    }

    @Override
    public boolean isKingInCheck() {
        Coordinate kingCoordinate = getKingCoordinate(getCurrentPlayer());
        return isSquareAttackedBy(kingCoordinate);
    }

    @Override
    public boolean isSquareAttackedBy(Coordinate coordinate) {
        return getAttackedSquares(getOpponentPlayer()).contains(coordinate);
    }

    private List<Coordinate> getAttackedSquares(Player attackingPlayer) {
        return piecesMap.get(attackingPlayer).stream()
                .flatMap(piece -> piece.generateMovements().stream())
                .distinct()
                .toList();
    }

    private Coordinate getKingCoordinate(Player player) {
        Coordinate coordinate = piecesMap.get(player).stream()
                .filter(SelectedPiece::isKing)
                .findFirst()
                .map(SelectedPiece::getCoordinate)
                .orElse(null);

        assert coordinate != null : "King not found for player: " + player;

        return coordinate;
    }

    @Override
    public void add(SelectedPiece inStepPawn) {
        assert inStepPawn != null;
        pawnMapInStep.get(getCurrentPlayer()).add(inStepPawn);
    }

    @Override
    public void remove(SelectedPiece inStepPawn) {
        assert inStepPawn != null;
        pawnMapInStep.get(getCurrentPlayer()).remove(inStepPawn);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isOccupied(coordinate);
        assert isWithinBoardLimits(coordinate);
        remove(this::getCurrentPlayer, coordinate);
    }

    public void removeOpponentPlayerPiece(Coordinate coordinate) {
        assert coordinate != null;
        assert isOccupied(coordinate);
        assert isWithinBoardLimits(coordinate);
        remove(this::getOpponentPlayer, coordinate);
    }

    private void remove(Supplier<Player> color, Coordinate coordinate) {
        piecesMap.get(color.get()).removeIf(selectedPiece -> {
            if (selectedPiece.isAt(coordinate)) {
                return removedPieces.get(color.get()).add(selectedPiece);
            }
            return false;
        });
    }

    public boolean isKingClaimed() {
        return selectedPiece != null && selectedPiece.isKing();
    }

    public boolean isPawnClaimed() {
        return selectedPiece != null && selectedPiece.isPawn();
    }

    public List<Coordinate> getSelectedPieceInStepDiagonals() {
        assert selectedPiece != null;
        return selectedPiece.getEnPassantDiagonals();
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
        return selectedPiece != null && selectedPiece.isPawnPromoted();
    }

    public boolean isOccupied(Coordinate coordinate) {
        assert coordinate != null;
        return piecesMap.values().stream().flatMap(List::stream).anyMatch(piece -> piece.isAt(coordinate));
    }

    @Override
    public boolean isRival(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getOpponentPlayer()).map(SelectedPiece::getCoordinate).toList().contains(coordinate);
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
        return getPiecesBy(getCurrentPlayer()).map(SelectedPiece::getCoordinate).toList().contains(coordinate);
    }

    @Override
    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        assert coordinate != null;
        return pawnMapInStep.get(getOpponentPlayer()).stream().anyMatch(piece -> piece.isAt(coordinate));
    }

    public boolean isCheck() {
        return getPiecesBy(getOpponentPlayer()).anyMatch(this::isTheKingInValidMoves);
    }

    private boolean isTheKingInValidMoves(SelectedPiece piece) {
        assert piece != null;
        return canReach(piece.getCoordinate()) && piece.isKing();
    }

    public boolean canReach(Coordinate coordinate) {
        assert coordinate != null;
        assert selectedPiece != null;
        assert isWithinBoardLimits(coordinate);
        return selectedPiece.canReach(coordinate);
    }

    @Override
    public boolean isRookAvailableForCastling(Coordinate coordinate) {
        assert coordinate != null;
        return getPiecesBy(getCurrentPlayer())
                .filter(selectedPiece -> selectedPiece.isAt(coordinate))
                .findFirst()
                .map(selectedPiece -> selectedPiece.isRookAvailableForCastling())
                .orElse(false);
    }

    private Stream<SelectedPiece> getPiecesBy(Player player) {
        assert player != null;
        return piecesMap.get(player).stream();
    }

    public int getIndexCurrentPlayer() {
        return turn.getIndexCurrentPlayer();
    }

    public Player getCurrentPlayer() {
        return turn.getCurrentPlayer();
    }

    public Player getOpponentPlayer() {
        return turn.getOpponentPlayer();
    }

    public void endTurn() {
        turn.switchTurn();
        pawnMapInStep.get(getCurrentPlayer()).clear();
    }

    public boolean finished() {
        return false;
    }

}
