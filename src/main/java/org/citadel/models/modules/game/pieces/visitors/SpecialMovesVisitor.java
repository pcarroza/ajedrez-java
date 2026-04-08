package org.citadel.models.modules.game.pieces.visitors;

import java.util.ArrayList;
import java.util.List;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;
import org.citadel.models.modules.game.pieces.enums.CastlingSide;

public class SpecialMovesVisitor implements PieceVisitor {

    private List<Coordinate> movements = new ArrayList<>();

    public List<Coordinate> getMovements() {
        return movements;
    }

    @Override
    public void visit(King king) {
        if (king.isMoved())
            movements = new ArrayList<>();

        for (CastlingSide side : CastlingSide.values()) {
            if (king.isCastlingAvailable(side)) {
                movements.add(king.getCastingCoordinate(side));
            }
        }
    }

    @Override
    public void visit(Pawn pawn) {
        if (pawn.isOnEnPassantRow())
            movements = new ArrayList<>();

        List.of(pawn.getDiagonalLeft(), pawn.getDiagonalRight())
                .stream()
                .filter(ValidatorLimitsBoard.getInstance()::isWithinLimits)
                .filter(pawn::hasVulnerableRivalPawnBeside)
                .forEach(movements::add);
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
