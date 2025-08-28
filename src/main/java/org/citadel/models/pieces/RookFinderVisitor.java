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
    }

    @Override
    public void visit(Queen queen) {
    }

    @Override
    public void visit(Bishop bishop) {
    }

    @Override
    public void visit(Knight knight) {
    }

    @Override
    public void visit(Pawn pawn) {
    }
}
