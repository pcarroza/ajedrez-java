package org.citadel.models.pieces;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.specialmovesrules.SpecialMovesRulesGenerator;
import org.citadel.models.pieces.specialmovesrules.EnPassantPawnSpecialRuleGenerator;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createPawnMoveRulesBuilder;

public class Pawn extends Piece {

    private boolean initialState = true;

    private boolean isItPromoted = false;

    private boolean vulnerablePawn = false;

    private final SpecialMovesRulesGenerator specialGenerator;

    public Pawn(Coordinate coordinate, Color color) {
        super(coordinate, color);
        basedGenerator = createPawnMoveRulesBuilder(this);
        specialGenerator = new EnPassantPawnSpecialRuleGenerator(this);
    }

    @Override
    public void put(Coordinate target) {
        if (isInitialState()) {
            close();
        }
        if (inStep(target)) {
            vulnerablePawn = true;
            addPassantPawn(this);
        } else {
            vulnerablePawn = false;
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
        return getDisplacedBy(new Coordinate(doubleStep, 0)).equals(target);
    }

    private boolean isThePawnPromoted(Coordinate coordinate) {
        return ValidatorLimitsBoard.getInstance().isPieceEndBoardAt(coordinate);
    }

    private void changeToPromoted() {
        isItPromoted = true;
    }

    @Override
    public boolean isMovementValid(Coordinate target) {
        return super.isMovementValid(target) || specialGenerator.isMovementValid(target);
    }

    @Override
    public void generateMovements() {
        super.generateMovements();
        specialGenerator.generateMovements();
        validMovements = new ArrayList<>();
        validMovements.addAll(Stream.concat(specialGenerator.getMovements().stream(), basedGenerator.getMovements().stream()).toList());
    }

    @Override
    public boolean isThePawnPromoted() {
        return isItPromoted;
    }

    @Override
    public boolean isVulnerablePawn() {
        return vulnerablePawn;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }
}
