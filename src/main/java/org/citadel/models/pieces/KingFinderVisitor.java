package org.citadel.models.pieces;

public class KingFinderVisitor implements PieceVisitor {

    private boolean isKing = false;

    public boolean isKing() {
        return isKing;
    }

    @Override
    public void visit(King king) {
        isKing = true;
    }

    @Override
    public void visit(Queen queen) {
        // Does nothing
    }

    @Override
    public void visit(Rook rook) {
        // Does nothing
    }

    @Override
    public void visit(Bishop bishop) {
        // Does nothing
    }

    @Override
    public void visit(Knight knight) {
        // Does nothing
    }

    @Override
    public void visit(Pawn pawn) {
        // Does nothing
    }
}
