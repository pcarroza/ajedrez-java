package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.views.console.BoardView;

public class LocalMoveController {

    private final Board board;

    private final BoardView view;

    public LocalMoveController(Board board, BoardView view) {
        this.board = board;
        this.view = view;
    }

    public void executeMove(Coordinate target) {
        handleCapture(target);
        handleEnPassant(target);
        handleCastling(target);
        board.putPiece(target);
    }

    private void handleCapture(Coordinate target) {
        if (board.isEnemy(target)) {
            view.showCapture(board.getPieceSymbol(target));
            board.removeRivalPlayerPiece(target);
        }
    }

    private void handleEnPassant(Coordinate target) {
        if (!board.isPawnSelected())
            return;
        if (board.isSquareOccupied(target))
            return;
        if (!board.getSelectedPieceEnPassantDiagonals().contains(target))
            return;

        Coordinate rivalPawnCoordinate = new Coordinate(board.getSelectedPieceCoordinate().row(), target.column());
        if (board.isVulnerablePawnAt(rivalPawnCoordinate)) {
            view.showEnPassant();
            board.removeRivalPlayerPiece(rivalPawnCoordinate);
        }
    }

    private void handleCastling(Coordinate target) {
        if (!board.isKingSelected())
            return;

        Coordinate origin = board.getSelectedPieceCoordinate();
        if (Math.abs(origin.column() - target.column()) <= 1)
            return;

        int rookOldColumn = (target.column() < origin.column()) ? 1 : 8;
        int rookNewColumn = (target.column() < origin.column()) ? target.column() + 1 : target.column() - 1;
        board.movePiece(new Coordinate(target.row(), rookOldColumn), new Coordinate(target.row(), rookNewColumn));
        view.showCastling();
    }
}
