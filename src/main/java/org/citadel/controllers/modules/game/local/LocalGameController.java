package org.citadel.controllers.modules.game.local;

import java.util.List;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.models.modules.game.Game;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;

public class LocalGameController implements GameController {

    private final Game game;

    public LocalGameController(Game game) {
        this.game = game;
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
        game.movePiece(origin, target);
    }

    public boolean isMovementValid(Coordinate target) {
        return game.isMovementValid(target);
    }

    public List<Coordinate> getSelectedPieceMovements() {
        return game.getSelectedPieceMovements();
    }

    public boolean isWithinBoardLimits(Coordinate coordinate) {
        return game.isWithinBoardLimits(coordinate);
    }

    public boolean isSquareOccupied(Coordinate coordinate) {
        return game.isSquareOccupied(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return game.isEmpty(coordinate);
    }

    public boolean isPieceSelected(Coordinate coordinate) {
        return game.isPieceSelected(coordinate);
    }

    public boolean isEnemy(Coordinate coordinate) {
        return game.isEnemy(coordinate);
    }

    public boolean isJaque() {
        return game.isJaque();
    }

    public String getPieceSymbol(Coordinate coordinate) {
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

    public void promotePawn(String pieceType) {
        game.promotePawn(pieceType);
    }
}
