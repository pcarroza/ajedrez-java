package org.citadel.models;

import org.citadel.models.pieces.Color;
import org.citadel.models.pieces.Coordinate;

public class Game {

    private final Board board;

    public static final int NUMBER_PLAYERS = 2;

    public Game(Observer observer) {
        board = new Board();
        board.subscribe(observer);
    }

    public void selectPiece(Coordinate coordinate) {
        board.selectPiece(coordinate);
    }

    public void putPiece(Coordinate coordinate) {
        board.putSelectedPieceInThis(coordinate);
    }

    public boolean isBoxEmpty(Coordinate coordinate) {
        return board.isBoxEmpty(coordinate);
    }

    public boolean isMovementValid(Coordinate coordinate) {
        return board.isMovementValid(coordinate);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        board.removeCurrentPlayerPiece(coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        board.removeRivalPlayerPiece(coordinate);
    }

    public Color getCurrentPlayer() {
        return board.currentPlayer();
    }

    public Color getRivalPlayer() {
        return board.rivalPlayer();
    }

    public void change() {
        board.changeTurn();
    }

    public boolean isTheWhitePieceSelected(Coordinate coordinate) {
        return board.isTheWhitePieceSelected(coordinate);
    }

    public boolean isTheBlackPieceSelected(Coordinate coordinate) {
        return board.isTheBlackPieceSelected(coordinate);
    }

    public void initialize() {
        board.initialize();
    }

    public void begin() {
        board.begin();
    }

    public void end() {
        board.end();
    }

    public void exit() {
        board.exit();
    }

   
}
