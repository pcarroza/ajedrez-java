package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.strategies.BuilderMovementStrategy.buildRookMovements;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

import java.util.List;

public class RookRulerGenerator implements GeneratorMoveVisitor {

    private static RookRulerGenerator instance;

    private List<Coordinate> possibleMoves;

    private RookRulerGenerator() {
    }

    public static RookRulerGenerator getInstance() {
        if (instance == null) {
            instance = new RookRulerGenerator();
        }
        return instance;
    }

    public List<Coordinate> getPossibleMoves() {
        return possibleMoves;
    }

    @Override
    public void visit(Rook rook) {
        this.possibleMoves = buildRookMovements(rook);
    }

    @Override
    public void visit(Pawn pawn) {
        // It does nothing
    }

    @Override
    public void visit(Knight knight) {
        // It does nothing
    }

    @Override
    public void visit(Bishop bishop) {
        // It does nothing
    }

    @Override
    public void visit(Queen queen) {
        // It does nothing
    }

    @Override
    public void visit(King king) {
        // It does nothing
    }
}
