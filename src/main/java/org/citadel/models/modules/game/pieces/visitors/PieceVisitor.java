package org.citadel.models.modules.game.pieces.visitors;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

public interface PieceVisitor {
    void visit(King king);

    void visit(Queen queen);

    void visit(Rook rook);

    void visit(Bishop bishop);

    void visit(Knight knight);

    void visit(Pawn pawn);
}
