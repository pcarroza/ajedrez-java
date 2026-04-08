package org.citadel.models.modules.game.pieces.visitors;

public interface PieceVisitor {
    void visit(org.citadel.models.modules.game.pieces.King king);

    void visit(org.citadel.models.modules.game.pieces.Pawn pawn);

    void visit(org.citadel.models.modules.game.pieces.Queen queen);

    void visit(org.citadel.models.modules.game.pieces.Rook rook);

    void visit(org.citadel.models.modules.game.pieces.Bishop bishop);

    void visit(org.citadel.models.modules.game.pieces.Knight knight);
}
