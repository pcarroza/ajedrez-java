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
        // No hace nada
    }

    @Override
    public void visit(Rook rook) {
        // No hace nada
    }

    @Override
    public void visit(Bishop bishop) {
        // No hace nada
    }

    @Override
    public void visit(Knight knight) {
        // No hace nada
    }

    @Override
    public void visit(Pawn pawn) {
        // No hace nada
    }
}
