package org.citadel.models.modules.game;

import org.citadel.models.modules.game.pieces.enums.PieceSymbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.enums.PromotionType;
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

    public PieceSymbol getPieceSimbol(Coordinate coordinate) {
        return board.getPieceSymbol(coordinate);
    }

    public void selectPiece(Coordinate coordinate) {
        board.selectPiece(coordinate);
    }

    public void putPiece(Coordinate coordinate) {
        board.putPiece(coordinate);
    }

    public boolean isKingSelected() {
        return board.isKingClaimed();
    }

    public boolean isPawnSelected() {
        return board.isPawnClaimed();
    }

    public List<Coordinate> getSelectedPieceInStepDiagonals() {
        return board.getSelectedPieceInStepDiagonals();
    }

    public Coordinate getSelectedPieceCoordinate() {
        return board.getSelectedPieceCoordinate();
    }

    public void relocate(Coordinate origin, Coordinate target) {
        board.relocate(origin, target);
    }

    public boolean isVulnerablePawnAt(Coordinate coordinate) {
        return board.isVulnerablePawnAt(coordinate);
    }

    public boolean isOccupied(Coordinate coordinate) {
        return board.isOccupied(coordinate);
    }

    public boolean isEmpty(Coordinate coordinate) {
        return !board.isOccupied(coordinate);
    }

    public boolean canReach(Coordinate coordinate) {
        return board.canReach(coordinate);
    }

    public void removeCurrentPlayerPiece(Coordinate coordinate) {
        board.removeCurrentPlayerPiece(coordinate);
    }

    public void removeRivalPlayerPiece(Coordinate coordinate) {
        board.removeOpponentPlayerPiece(coordinate);
    }

    public int getIndexCurrentPlayer() {
        return board.getIndexCurrentPlayer();
    }

    public Player getCurrentPlayer() {
        return board.getCurrentPlayer();
    }

    public Player getRivalPlayer() {
        return board.getOpponentPlayer();
    }

    public void endTurn() {
        board.endTurn();
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

    public void promote(PromotionType promotionType) {
        board.promote(promotionType);
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

    public boolean isCheck() {
        return board.isCheck();
    }

    public List<Coordinate> getSelectedPieceMovements() {
        return board.getSelectedPieceMovements();
    }

    public boolean hasClaimed(Coordinate coordinate) {
        return board.hasClaimed(coordinate);
    }

    public boolean isRival(Coordinate coordinate) {
        return board.isRival(coordinate);
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

    public static void main(String[] args) {
        Game game = new Game(null);
        GameController controller = new LocalGameController(game);
        MoveController move = new LocalMoveController(controller);
        new GameView(controller, move).start();
    }
}
