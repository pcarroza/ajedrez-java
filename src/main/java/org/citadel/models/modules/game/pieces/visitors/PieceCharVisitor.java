package org.citadel.models.modules.game.pieces.visitors;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.enums.PieceSimbol;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

public class PieceCharVisitor implements PieceVisitor {

    private String simbol;

    public String getSimbol() {
        return simbol;
    }

    @Override
    public void visit(King king) {
        simbol = PieceSimbol.KING.getValue();
    }

    @Override
    public void visit(Queen queen) {
        simbol = PieceSimbol.QUEEN.getValue();
    }

    @Override
    public void visit(Rook rook) {
        simbol = PieceSimbol.ROOK.getValue();
    }

    @Override
    public void visit(Bishop bishop) {
        simbol = PieceSimbol.BISHOP.getValue();
    }

    @Override
    public void visit(Knight knight) {
        simbol = PieceSimbol.KNIGHT.getValue();
    }

    @Override
    public void visit(Pawn pawn) {
        simbol = PieceSimbol.PAWN.getValue();
    }
}
