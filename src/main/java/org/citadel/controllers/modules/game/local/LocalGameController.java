package org.citadel.controllers.modules.game.local;

import java.util.List;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.models.modules.game.Game;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.PieceSimbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.enums.PromotionType;

public class LocalGameController implements GameController {

    private final Game game;

    public LocalGameController(Game game) {
        this.game = game;
    }

    public void endTurn() {
        game.endTurn();
    }

    public void resetSelectedPiece() {
        game.resetSelectedPiece();
    }

    public boolean isFinished() {
        return game.finished();
    }

    public Player getCurrentPlayer() {
        return game.getCurrentPlayer();
    }

    public Player getRivalPlayer() {
        return game.getRivalPlayer();
    }

    public int getIndexCurrentPlayer() {
        return game.getIndexCurrentPlayer();
    }

    public void selectPiece(Coordinate origin) {
        game.selectPiece(origin);
    }

    public void putPiece(Coordinate coordinate) {
        game.putPiece(coordinate);
    }

    public void movePiece(Coordinate origin, Coordinate target) {
        game.relocate(origin, target);
    }

    public boolean canReach(Coordinate target) {
        return game.canReach(target);
    }

    public List<Coordinate> getSelectedPieceMovements() {
        return game.getSelectedPieceMovements();
    }

    public boolean isWithinBoardLimits(Coordinate coordinate) {
        return game.isWithinBoardLimits(coordinate);
    }

    public boolean isOccupied(Coordinate square) {
        return game.isOccupied(square);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return game.isEmpty(coordinate);
    }

    public boolean hasClaimed(Coordinate coordinate) {
        return game.hasClaimed(coordinate);
    }

    public boolean isRival(Coordinate coordinate) {
        return game.isRival(coordinate);
    }

    public boolean isCheck() {
        return game.isCheck();
    }

    public PieceSimbol getPieceSymbol(Coordinate coordinate) {
        return game.getPieceSimbol(coordinate);
    }

    public boolean isKingSelected() {
        return game.isKingSelected();
    }

    public boolean isPawnSelected() {
        return game.isPawnSelected();
    }

    public Coordinate getSelectedPieceCoordinate() {
        return game.getSelectedPieceCoordinate();
    }

    public List<Coordinate> getSelectedPieceEnPassantDiagonals() {
        return game.getSelectedPieceEnPassantDiagonals();
    }

    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        return game.isVulnerablePawnAt(coordinate);
    }

    public boolean isTheWhitePieceSelected(Coordinate coordinate) {
        return game.isTheWhitePieceSelected(coordinate);
    }

    public boolean isTheBlackPieceSelected(Coordinate coordinate) {
        return game.isTheBlackPieceSelected(coordinate);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        game.removeCurrentPlayerPiece(coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        game.removeRivalPlayerPiece(coordinate);
    }

    public boolean isThePawnPromoted() {
        return game.isThePawnPromoted();
    }

    public void promote(PromotionType promotionType) {
        game.promote(promotionType);
    }

    public void initialize() {
        game.initialize();
    }

    public void begin() {
        game.begin();
    }

    public void end() {
        game.end();
    }

    public void exit() {
        game.exit();
    }
}
