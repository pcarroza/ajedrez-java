package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;

import java.util.List;

import org.citadel.models.modules.game.Game;

public class LocalController {

    private Game game;

    public LocalController(Game game) {
        this.game = game;
    }

    public void selectPiece(Coordinate origin) {
        game.selectPiece(origin);
    }

    public void switchTurn() {
        game.switchTurn();
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

    public boolean isWithinBoardLimits(Coordinate coordinate) {
        return game.isWithinBoardLimits(coordinate);
    }

    public boolean isSquareOccupied(Coordinate coordinate) {
        return game.isSquareOccupied(coordinate);
    }

    public boolean isPieceSelected(Coordinate coordinate) {
        return game.isTheBlackPieceSelected(coordinate);
    }

    public boolean isMovementValid(Coordinate target) {
        return game.isMovementValid(target);
    }

    public boolean isJaque() {
        return game.isJaque();
    }

    public Player getRivalPlayer() {
        return game.getRivalPlayer();
    }

    public List<Coordinate> getSelectedPieceMovements() {
        return game.getSelectedPieceEnPassantDiagonals();
    }

    public String getPieceSymbol(Coordinate c) {
        return game.getPieceSimbol(c);
    }
}
