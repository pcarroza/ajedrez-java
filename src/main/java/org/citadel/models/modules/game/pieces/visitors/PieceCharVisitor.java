package org.citadel.models.modules.game.pieces.visitors;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.enums.PieceSimbol;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

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
