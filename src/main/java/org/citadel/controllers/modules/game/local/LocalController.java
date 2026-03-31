package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.Game;

public class LocalController {

    private final Game game;

    public LocalController(Game game) {
        this.game = game;
    }

    public String getPieceSimbol(Coordinate coordinate) {
        return game.getPieceSimbol(coordinate);
    }

    public void put(Coordinate coordinate) {
        game.putPiece(coordinate);
    }

    public void select(Coordinate coordinate) {
        game.selectPiece(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return game.isEmpty(coordinate);
    }

    public boolean isMovementValid(Coordinate coordinate) {
        return game.isMovementValid(coordinate);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        game.removeCurrentPlayerPiece(coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        game.removeRivalPlayerPiece(coordinate);
    }

    public Player getCurrentPlayer() {
        return game.getCurrentPlayer();
    }

    public Player getRivalPlayer() {
        return game.getRivalPlayer();
    }

    public void switchTurn() {
        game.switchTurn();
    }

    public boolean isTheWhitePieceSelected(Coordinate coordinate) {
        return game.isTheWhitePieceSelected(coordinate);
    }

    public boolean isTheBlackPieceSelected(Coordinate coordinate) {
        return game.isTheBlackPieceSelected(coordinate);
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
