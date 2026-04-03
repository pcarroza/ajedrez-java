package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.controllers.modules.game.MoveController;
import org.citadel.models.modules.game.pieces.Coordinate;

public class LocalMoveController implements MoveController {

    private GameController gameController;

    public LocalMoveController(GameController gameController) {
        this.gameController = gameController;
    }

    public void executeMove(Coordinate target) {
        handleCapture(target);
        handleEnPassant(target);
        handleCastling(target);
        gameController.putPiece(target);
    }

    @Override
    public boolean isThePawnPromoted() {
        return gameController.isThePawnPromoted();
    }

    @Override
    public void promotePawn(String p) {
        gameController.promotePawn(p);
    }

    private void handleCapture(Coordinate target) {
        if (gameController.isEnemy(target))
            gameController.removeRivalPlayerPiece(target);
    }

    private void handleEnPassant(Coordinate target) {
        if (!gameController.isPawnSelected())
            return;
        if (!gameController.isEmpty(target))
            return;
        if (!gameController.getSelectedPieceEnPassantDiagonals().contains(target))
            return;
        Coordinate rivalPawn = new Coordinate(gameController.getSelectedPieceCoordinate().row(), target.column());
        if (gameController.isVulnerablePawnAt(rivalPawn))
            gameController.removeRivalPlayerPiece(rivalPawn);
    }

    private void handleCastling(Coordinate target) {
        if (!gameController.isKingSelected())
            return;
        Coordinate origin = gameController.getSelectedPieceCoordinate();
        if (Math.abs(origin.column() - target.column()) <= 1)
            return;
        int rookOldCol = (target.column() < origin.column()) ? 1 : 8;
        int rookNewCol = (target.column() < origin.column()) ? target.column() + 1 : target.column() - 1;
        gameController.movePiece(new Coordinate(target.row(), rookOldCol), new Coordinate(target.row(), rookNewCol));
    }
}
