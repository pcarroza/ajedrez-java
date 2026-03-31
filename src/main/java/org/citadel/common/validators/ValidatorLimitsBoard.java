package org.citadel.common.validators;

import org.citadel.models.modules.game.pieces.Coordinate;

import static org.citadel.common.constants.BoardConstants.MAX_LIMIT;

public class ValidatorLimitsBoard {

    private static ValidatorLimitsBoard validatorLimitsBoard = null;

    public static ValidatorLimitsBoard getInstance() {
        if (validatorLimitsBoard == null) {
            validatorLimitsBoard = new ValidatorLimitsBoard();
        }
        return validatorLimitsBoard;
    }

    private static final ClosedInterval<Integer> LIMITS = new ClosedInterval<>(1, MAX_LIMIT);

    public boolean isWithinLimits(Coordinate coordinate) {
        return LIMITS.isIncluded(coordinate.row()) && LIMITS.isIncluded(coordinate.column());
    }

    public boolean isPieceEndBoardAt(Coordinate coordinate) {
        return LIMITS.isEqualToMin(coordinate.row()) || LIMITS.isEqualToMax(coordinate.column());
    }
}
