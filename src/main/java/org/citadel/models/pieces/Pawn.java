package org.citadel.models.pieces;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.specialmovesrules.SpecialMoveRule;
import org.citadel.models.pieces.specialmovesrules.SpecialStepMovementRule;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.FacadeMotionManager.createPawnMoveRulesManager;

public class Pawn extends Piece {

    private boolean initialState = true;

    private boolean isItPromoted = false;

    private final SpecialMoveRule specialMoveRule;

    private List<Coordinate> concatMovements;

    public Pawn(Coordinate coordinate, Color color) {
        super(coordinate, color);
        moveRulesManager = createPawnMoveRulesManager(this);
        specialMoveRule = new SpecialStepMovementRule(this);
    }

    @Override
    public void put(Coordinate target) {
        if (isInitialState()) {
            close();
        }
        if (inStep(target)) {
            addPassantPawn(this);
        }
        if (isThePawnPromoted(target)) {
            changeToPromoted();
        }
        super.put(target.copy());
    }

    public boolean isInitialState() {
        return initialState;
    }

    private void close() {
        initialState = false;
    }

    private boolean inStep(Coordinate target) {
        final int doubleStep = 2;
        return getDisplacedCoordinateBy(new Coordinate(doubleStep, 0)).equals(target);
    }

    private boolean isThePawnPromoted(Coordinate coordinate) {
        return ValidatorLimitsBoard.getInstance().isPieceEndBoardAt(coordinate);
    }

    private void changeToPromoted() {
        isItPromoted = true;
    }

    @Override
    public boolean isMovementValid(Coordinate target) {
        return super.isMovementValid(target) || specialMoveRule.isMovementValid(target);
    }

    @Override
    public void buildMovements() {
        super.buildMovements();
        specialMoveRule.buildMovements();
        concatMovements = new ArrayList<>();
        concatMovements.addAll(Stream
                .concat(specialMoveRule.getMovements().stream(), moveRulesManager.getMovements().stream()).toList());
    }

    @Override
    public void notifiesMovementsToTheBoard() {
        notify(concatMovements);
    }

    @Override
    public boolean isThePawnPromoted() {
        return isItPromoted;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }
}
