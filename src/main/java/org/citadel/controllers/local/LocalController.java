package org.citadel.controllers.local;

import org.citadel.models.pieces.Color;
import org.citadel.models.pieces.Coordinate;
import org.citadel.models.Game;

public class LocalController {

    private final Game game;

    public LocalController(Game game) {
        this.game = game;
    }

    public void put(Coordinate coordinate) {
        game.putPiece(coordinate);
    }

    public void select(Coordinate coordinate) {
        game.selectPiece(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return game.isBoxEmpty(coordinate);
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

    public Color getCurrentPlayer() {
        return game.getCurrentPlayer();
    }

    public Color getRivalPlayer() {
        return game.getRivalPlayer();
    }

    public void change() {
        game.change();
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
