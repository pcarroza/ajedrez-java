package org.citadel.models.pieces;

public class PawnPromotionVisitor implements PieceVisitor {

    private boolean isPromoted = false;

    public boolean isPromoted() {
        return isPromoted;
    }

    @Override
    public void visit(Pawn pawn) {
        isPromoted = pawn.isPromoted();
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
}
