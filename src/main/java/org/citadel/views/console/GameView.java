package org.citadel.views.console;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.controllers.modules.game.MoveController;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.PromotionType;

public class GameView {

    private final GameController gameController;

    private final MoveController moveController;

    private final BoardView boardView;

    private final InputView inputView;

    public GameView(GameController gameController, MoveController moveController) {
        this.gameController = gameController;
        this.moveController = moveController;
        this.boardView = new BoardView(gameController);
        this.inputView = new InputView();
    }

    public void start() {
        do {
            boardView.render();
            Coordinate origin = selectPiece();
            if (!tryMove(origin))
                continue;
            handlePostMove();
            gameController.endTurn();
            gameController.resetSelectedPiece();
        } while (!gameController.isFinished());
    }

    private Coordinate selectPiece() {
        while (true) {
            boardView.showTurn(gameController.getCurrentPlayer());
            Coordinate origin = inputView.askCoordinate("Columna (a-h): ", "Fila (1-8): ");

            if (!gameController.isWithinBoardLimits(origin)) {
                boardView.showError("Coordenada fuera de los límites.");
                continue;
            }
            if (!gameController.isOccupied(origin)) {
                boardView.showError("No hay ninguna pieza en esa posición.");
                continue;
            }
            if (!gameController.hasClaimed(origin)) {
                boardView.showError("Esa pieza no te pertenece.");
                continue;
            }

            gameController.selectPiece(origin);

            if (gameController.getSelectedPieceMovements().isEmpty()) {
                boardView.showError("La pieza no tiene movimientos legales.");
                continue;
            }

            boardView.showSelectedPiece(gameController.getPieceSymbol(origin),
                    gameController.getSelectedPieceMovements());
            return origin;
        }
    }

    private boolean tryMove(Coordinate origin) {
        while (true) {
            Coordinate target = inputView.askDestinationOrCancel("Columna destino (a-h): ");
            if (target == null) {
                gameController.resetSelectedPiece();
                return false;
            }
            if (!gameController.canReach(target)) {
                boardView.showError("Movimiento no permitido.");
                continue;
            }
            handleMoveEffects(target);
            moveController.executeMove(target);
            boardView.showMoveCompleted(target);
            handlePromotion();
            return true;
        }
    }

    private void handleMoveEffects(Coordinate target) {
        if (gameController.isRival(target))
            boardView.showCapture(gameController.getPieceSymbol(target).getValue());
    }

    private void handlePromotion() {
        if (!moveController.isThePawnPromoted())
            return;
        boardView.showPromotion();
        PromotionType type = PromotionType.fromString(inputView.askPromotionChoice());
        moveController.promote(type);
    }

    private void handlePostMove() {
        if (gameController.isCheck())
            boardView.showCheck(gameController.getRivalPlayer());
    }
}
