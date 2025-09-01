package org.citadel.models.pieces;

public interface PieceVisitor {

    void visit(King king);

    void visit(Queen queen);

    void visit(Rook rook);

    void visit(Bishop bishop);

    void visit(Knight knight);

    void visit(Pawn pawn);
}
