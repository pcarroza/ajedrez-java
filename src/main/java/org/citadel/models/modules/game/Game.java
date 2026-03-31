package org.citadel.models.modules.game;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.Coordinate;

public class Game {

    private final Board board;

    public static final int NUMBER_PLAYERS = 2;

    public Game(Observer observer) {
        board = new Board();
        board.subscribe(observer);
    }

    public String getPieceSimbol(Coordinate coordinate) {
        return board.getPieceSymbol(coordinate);
    }

    public void selectPiece(Coordinate coordinate) {
        board.selectPiece(coordinate);
    }

    public void putPiece(Coordinate coordinate) {
        board.putPiece(coordinate);
    }

    public boolean isKingSelected() {
        return board.isKingSelected();
    }

    public boolean isPawnSelected() {
        return board.isPawnSelected();
    }

    public java.util.List<Coordinate> getSelectedPieceEnPassantDiagonals() {
        return board.getSelectedPieceEnPassantDiagonals();
    }

    public Coordinate getSelectedPieceCoordinate() {
        return board.getSelectedPieceCoordinate();
    }

    public void movePiece(Coordinate origin, Coordinate target) {
        board.movePiece(origin, target);
    }

    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        return board.isVulnerablePawnAt(coordinate);
    }

    public boolean isSquareOccupied(Coordinate coordinate) {
        return board.isSquareOccupied(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return !board.isSquareOccupied(coordinate);
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

    public int getIndexCurrentPlayer() {
        return board.getIndexCurrentPlayer();
    }

    public Player getCurrentPlayer() {
        return board.getCurrentPlayer();
    }

    public Player getRivalPlayer() {
        return board.getRivalPlayer();
    }

    public void switchTurn() {
        board.switchTurn();
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
