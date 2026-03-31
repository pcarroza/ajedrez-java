package org.citadel.models.modules.game.pieces.visitors;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

public class RookCastlingVisitor implements PieceVisitor {

    private boolean isAvailable = false;

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public void visit(Rook rook) {
        isAvailable = !rook.isMoved();
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
