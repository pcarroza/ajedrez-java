package org.citadel.views.console;

import org.citadel.controllers.modules.game.GameController;
import org.citadel.controllers.modules.game.MoveController;
import org.citadel.models.modules.game.pieces.Coordinate;

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
            gameController.switchTurn();
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
            if (!gameController.isSquareOccupied(origin)) {
                boardView.showError("No hay ninguna pieza en esa posición.");
                continue;
            }
            if (!gameController.isPieceSelected(origin)) {
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
            if (!gameController.isMovementValid(target)) {
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
        if (gameController.isEnemy(target))
            boardView.showCapture(gameController.getPieceSymbol(target));
    }

    private void handlePromotion() {
        if (!moveController.isThePawnPromoted())
            return;
        boardView.showPromotion();
        moveController.promotePawn(inputView.askPromotionChoice());
    }

    private void handlePostMove() {
        if (gameController.isJaque())
            boardView.showCheck(gameController.getRivalPlayer());
    }
}
