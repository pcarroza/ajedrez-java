package org.citadel.models.pieces.visitors;

import org.citadel.models.pieces.Bishop;
import org.citadel.models.pieces.King;
import org.citadel.models.pieces.Knight;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Queen;
import org.citadel.models.pieces.Rook;

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
