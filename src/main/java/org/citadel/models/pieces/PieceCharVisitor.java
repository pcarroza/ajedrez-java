package org.citadel.models.pieces;

import org.citadel.views.console.PieceView;

public class PieceCharVisitor implements PieceVisitor {

    private String pieceChar;

    public String getPieceChar() {
        return pieceChar;
    }

    @Override
    public void visit(King king) {
        pieceChar = PieceView.KING.getValue();
    }

    @Override
    public void visit(Queen queen) {
        pieceChar = PieceView.QUEEN.getValue();
    }

    @Override
    public void visit(Rook rook) {
        pieceChar = PieceView.ROOK.getValue();
    }

    @Override
    public void visit(Bishop bishop) {
        pieceChar = PieceView.BISHOP.getValue();
    }

    @Override
    public void visit(Knight knight) {
        pieceChar = PieceView.KNIGHT.getValue();
    }

    @Override
    public void visit(Pawn pawn) {
        pieceChar = PieceView.PAWN.getValue();
    }
}
