package org.citadel.models.pieces.visitors;

import org.citadel.models.pieces.Bishop;
import org.citadel.models.pieces.King;
import org.citadel.models.pieces.Knight;
import org.citadel.models.pieces.Pawn;
import org.citadel.models.pieces.enums.PieceSimbol;
import org.citadel.models.pieces.Queen;
import org.citadel.models.pieces.Rook;

public class PieceCharVisitor implements PieceVisitor {

    private String pieceChar;

    public String getPieceChar() {
        return pieceChar;
    }

    @Override
    public void visit(King king) {
        pieceChar = PieceSimbol.KING.getValue();
    }

    @Override
    public void visit(Queen queen) {
        pieceChar = PieceSimbol.QUEEN.getValue();
    }

    @Override
    public void visit(Rook rook) {
        pieceChar = PieceSimbol.ROOK.getValue();
    }

    @Override
    public void visit(Bishop bishop) {
        pieceChar = PieceSimbol.BISHOP.getValue();
    }

    @Override
    public void visit(Knight knight) {
        pieceChar = PieceSimbol.KNIGHT.getValue();
    }

    @Override
    public void visit(Pawn pawn) {
        pieceChar = PieceSimbol.PAWN.getValue();
    }
}
