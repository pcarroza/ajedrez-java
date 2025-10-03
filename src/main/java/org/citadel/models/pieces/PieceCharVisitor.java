package org.citadel.models.pieces;

public class PieceCharVisitor implements PieceVisitor {

    private String pieceChar;

    public String getPieceChar() {
        return pieceChar;
    }

    @Override
    public void visit(King king) {
        pieceChar = PieceChar.KING.getValue();
    }

    @Override
    public void visit(Queen queen) {
        pieceChar = PieceChar.QUEEN.getValue();
    }

    @Override
    public void visit(Rook rook) {
        pieceChar = PieceChar.ROOK.getValue();
    }

    @Override
    public void visit(Bishop bishop) {
        pieceChar = PieceChar.BISHOP.getValue();
    }

    @Override
    public void visit(Knight knight) {
        pieceChar = PieceChar.KNIGHT.getValue();
    }

    @Override
    public void visit(Pawn pawn) {
        pieceChar = PieceChar.PAWN.getValue();
    }
}
