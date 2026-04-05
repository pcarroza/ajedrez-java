package org.citadel.models.modules.game;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.views.console.GameView;

import java.util.List;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.controllers.modules.game.MoveController;
import org.citadel.controllers.modules.game.local.LocalGameController;
import org.citadel.controllers.modules.game.local.LocalMoveController;
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

    public boolean isThePawnPromoted() {
        return board.isThePawnPromoted();
    }

    public void promotePawn(String pieceType) {
        board.promotePawn(pieceType);
    }

    public void resetSelectedPiece() {
        board.resetSelectedPiece();
    }

    public boolean finished() {
        return board.finished();
    }

    public boolean isWithinBoardLimits(Coordinate coordinate) {
        return board.isWithinBoardLimits(coordinate);
    }

    public boolean isJaque() {
        return board.isJaque();
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

    public List<Coordinate> getSelectedPieceMovements() {
        return board.getSelectedPieceMovements();
    }

    public boolean isPieceSelected(Coordinate coordinate) {
        return board.isPieceSelected(coordinate);
    }

    public boolean isEnemy(Coordinate coordinate) {
        return board.isEnemy(coordinate);
    }

    public static void main(String[] args) {
        Game game = new Game(null);
        GameController controller = new LocalGameController(game);
        MoveController move = new LocalMoveController(controller);
        new GameView(controller, move).start();
    }
}
