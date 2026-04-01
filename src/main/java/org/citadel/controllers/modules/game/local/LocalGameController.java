package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.views.console.BoardView;

public class LocalGameController {

    private final Board board;

    private final BoardView boardView;

    private final LocalInputController inputController;

    private final LocalMoveController moveController;

    public LocalGameController(Board board, BoardView boardView, LocalInputController inputController, LocalMoveController moveController) {
        this.board = board;
        this.boardView = boardView;
        this.inputController = inputController;
        this.moveController = moveController;
    }

    public void start() {

    }

    private Coordinate selectPiece() {
        return null;
    }

    private boolean selectDestinationAndMove(Coordinate origin) {
        return false;
    }

    private void handlePostMove() {

    }

}
