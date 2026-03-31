package org.citadel.models.modules.game.pieces.visitors;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;
import org.citadel.models.modules.game.pieces.enums.Player;

import java.util.ArrayList;
import java.util.List;

public class EnPassantTargetVisitor implements PieceVisitor {

    private final List<Coordinate> diagonals = new ArrayList<>();

    public List<Coordinate> getDiagonals() {
        return diagonals;
    }

    @Override
    public void visit(Pawn pawn) {
        int row = pawn.getCoordinate().row();
        int expectedRow = (pawn.getPlayer() == Player.WHITE) ? 5 : 4;
        if (row == expectedRow) {
            diagonals.add(pawn.getDiagonalLeft());
            diagonals.add(pawn.getDiagonalRight());
        }
    }

    @Override
    public void visit(King king) {
        // Does nothing
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
}
