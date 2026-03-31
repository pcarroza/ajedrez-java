package org.citadel.models.pieces.visitors;

import org.citadel.models.pieces.Bishop;
import org.citadel.models.pieces.King;
import org.citadel.models.pieces.Knight;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Queen;
import org.citadel.models.pieces.Rook;

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
