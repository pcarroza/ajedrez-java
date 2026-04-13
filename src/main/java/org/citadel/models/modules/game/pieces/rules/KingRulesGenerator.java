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

public class KingRulesGenerator implements MovementRuleGenerator {

    private static KingRulesGenerator instance;

    private List<Coordinate> possibleMoves;

    private KingRulesGenerator() {
    }

    public static KingRulesGenerator getInstance() {
        if (instance == null) {
            instance = new KingRulesGenerator();
        }
        return instance;
    }

    public List<Coordinate> getPossibleMoves() {
        return possibleMoves;
    }

    public List<Coordinate> generate(Piece piece) {
        final int simpleStep = 1;

        var offsets = List.of(
                new Coordinate(simpleStep, -simpleStep),
                new Coordinate(simpleStep, 0),
                new Coordinate(simpleStep, simpleStep),
                new Coordinate(-simpleStep, 0),
                new Coordinate(-simpleStep, -simpleStep),
                new Coordinate(-simpleStep, simpleStep),
                new Coordinate(0, -simpleStep),
                new Coordinate(0, simpleStep));

        return generateLegalMoves(piece, offsets);
    }

    @Override
    public void visit(King king) {
        this.possibleMoves = generate(king);
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
}