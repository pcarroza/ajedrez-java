package org.citadel.models.modules.game.pieces.rules;

import java.util.ArrayList;
import java.util.List;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

public class GeneratorLegalMoves {

    public static List<Coordinate> generateLegalMoves(Piece piece, List<Coordinate> offsets) {
        List<Coordinate> movements = new ArrayList<>();

        for (Coordinate offset : offsets) {
            Coordinate coordinate = piece.getDisplacedBy(offset);
            if (ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate)) {
                if (!piece.isPieceSamePlayerAt(coordinate)) {
                    movements.add(coordinate);
                }
            }
        }

        return movements;
    }
}
