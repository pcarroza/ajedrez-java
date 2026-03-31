package org.citadel.models.modules.game.pieces.visitors;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

public class PawnFinderVisitor implements PieceVisitor {

    private boolean isPawn = false;

    public boolean isPawn() {
        return isPawn;
    }

    @Override
    public void visit(Pawn pawn) {
        isPawn = true;
    }

    @Override
    public void visit(King king) {
    }

    @Override
    public void visit(Queen queen) {
    }

    @Override
    public void visit(Rook rook) {
    }

    @Override
    public void visit(Bishop bishop) {
    }

    @Override
    public void visit(Knight knight) {
    }
}
