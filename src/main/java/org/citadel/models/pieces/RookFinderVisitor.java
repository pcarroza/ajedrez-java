package org.citadel.models.pieces;

public class RookFinderVisitor implements PieceVisitor {

    private boolean isRook = false;

    public boolean isRook() {
        return isRook;
    }

    @Override
    public void visit(Rook rook) {
        isRook = true;
    }

    @Override
    public void visit(King king) {
        // Does nothing
    }

    @Override
    public void visit(Queen queen) {
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
