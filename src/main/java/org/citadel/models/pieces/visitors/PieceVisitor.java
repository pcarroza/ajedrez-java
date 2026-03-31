package org.citadel.models.pieces.visitors;

import org.citadel.models.pieces.Bishop;
import org.citadel.models.pieces.King;
import org.citadel.models.pieces.Knight;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.Queen;
import org.citadel.models.pieces.Rook;

public interface PieceVisitor {

    void visit(King king);

    void visit(Queen queen);

    void visit(Rook rook);

    void visit(Bishop bishop);

    void visit(Knight knight);

    void visit(Pawn pawn);
}
