package org.citadel.models.support;

import org.citadel.models.modules.game.Board;
import org.citadel.models.modules.game.pieces.enums.Player;

public class BoardDsl {

    private Player turn;

    private String square;

    public static BoardDsl aBoardAtStartingPosition() {
        return new BoardDsl();
    }

    public BoardDsl withTurn(Player turn) {
        this.turn = turn;
        return this;
    }

    public Assertions selectKinghtAt(String square) {
        this.square = square;
        Board board = new Board();
        if (turn == Player.WHITE) {
            board.switchTurn();
        }
        board.selectPiece(Square.from(this.square).toCoordinate());
        var movements = board.getSelectedPieceMovements()
                .stream()
                .map(it -> Square.from(it).toString())
                .toList();
        return new Assertions(movements);
    }
}
