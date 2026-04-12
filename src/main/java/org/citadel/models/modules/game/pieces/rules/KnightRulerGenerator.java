package org.citadel.models.modules.game.pieces.rules;

import static org.citadel.models.modules.game.pieces.rules.GeneratorLegalMoves.generateLegalMoves;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Piece;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

import java.util.List;

public class KnightRulerGenerator implements GeneratorMoveVisitor {

    private static KnightRulerGenerator instance;

    private List<Coordinate> possibleMoves;

    private KnightRulerGenerator() {
    }

    public static KnightRulerGenerator getInstance() {
        if (instance == null) {
            instance = new KnightRulerGenerator();
        }
        return instance;
    }

    public List<Coordinate> getPossibleMoves() {
        return possibleMoves;
    }

    public List<Coordinate> generate(Piece piece) {
        final int doubleStep = 2;
        final int simpleStep = 1;

        var offsets = List.of(
                new Coordinate(doubleStep, simpleStep),
                new Coordinate(simpleStep, doubleStep),
                new Coordinate(-simpleStep, doubleStep),
                new Coordinate(-doubleStep, -simpleStep),
                new Coordinate(-simpleStep, -doubleStep),
                new Coordinate(simpleStep, -doubleStep),
                new Coordinate(doubleStep, -simpleStep),
                new Coordinate(-doubleStep, simpleStep));

        return generateLegalMoves(piece, offsets);
    }

    @Override
    public void visit(Knight knight) {
        this.possibleMoves = generate(knight);
    }

    @Override
    public void visit(Pawn pawn) {
        // It does nothing
    }

    @Override
    public void visit(Rook rook) {
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
