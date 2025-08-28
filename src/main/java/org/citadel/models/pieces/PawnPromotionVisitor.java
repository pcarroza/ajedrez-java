package org.citadel.models.pieces;

public class PawnPromotionVisitor implements PieceVisitor {
    private boolean isPromoted = false;

    public boolean isPromoted() {
        return isPromoted;
    }

    @Override
    public void visit(Pawn pawn) {
        // Accedemos al estado de promoción del peón
        isPromoted = pawn.isPromoted();
    }

    // Para cualquier otra pieza, la promoción no es aplicable.
    @Override public void visit(King king) {}
    @Override public void visit(Queen queen) {}
    @Override public void visit(Rook rook) {}
    @Override public void visit(Bishop bishop) {}
    @Override public void visit(Knight knight) {}
}
