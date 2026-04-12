package org.citadel.models.modules.game.pieces.rules;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

import java.util.List;

public class GeneratorInspector {

    private GeneratorInspector() {
    }

    public static List<Coordinate> generatorMovements(Bishop bishop) {
        BishopRulerGenerator generator = BishopRulerGenerator.getInstance();
        bishop.accept(generator);
        return generator.getPossibleMoves();
    }

    public static List<Coordinate> generatorMovements(King king) {
        KingRulesGenerator generator = KingRulesGenerator.getInstance();
        king.accept(generator);
        return generator.getPossibleMoves();
    }

    public static List<Coordinate> generatorMovements(Knight knight) {
        KnightRulerGenerator generator = KnightRulerGenerator.getInstance();
        knight.accept(generator);
        return generator.getPossibleMoves();
    }

    public static List<Coordinate> generatorMovements(Queen queen) {
        QueenRulerGenerator generator = QueenRulerGenerator.getInstance();
        queen.accept(generator);
        return generator.getPossibleMoves();
    }

    public static List<Coordinate> generatorMovements(Rook rook) {
        RookRulerGenerator generator = RookRulerGenerator.getInstance();
        rook.accept(generator);
        return generator.getPossibleMoves();
    }

    public static List<Coordinate> generatorMovements(Pawn pawn) {
        PawnRulerGenerator generator = PawnRulerGenerator.getInstance();
        pawn.accept(generator);
        return generator.getPossibleMoves();
    }
}
