package org.citadel.common.validators;

import org.citadel.models.pieces.Coordinate;

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
        return LIMITS.isIncluded(coordinate.getRow()) && LIMITS.isIncluded(coordinate.getColumn());
    }

    public boolean isPieceEndBoardAt(Coordinate coordinate) {
        return LIMITS.isEqualToMin(coordinate.getRow()) || LIMITS.isEqualToMax(coordinate.getColumn());
    }
}
