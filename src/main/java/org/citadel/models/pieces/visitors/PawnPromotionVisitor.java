package org.citadel.models.pieces.visitors;

import org.citadel.models.pieces.Bishop;
import org.citadel.models.pieces.King;
import org.citadel.models.pieces.Knight;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Queen;
import org.citadel.models.pieces.Rook;

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
