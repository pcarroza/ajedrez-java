package org.citadel.models.pieces;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.specialmovesrules.SpecialMovesRulesGenerator;
import org.citadel.models.pieces.specialmovesrules.EnPassantPawnSpecialRuleGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createPawnMoveRulesBuilder;

public class Pawn extends Piece {

    private boolean initialState = true;

    private boolean isItPromoted = false;

    private boolean vulnerablePawn = false;

    private final SpecialMovesRulesGenerator specialGenerator;

    public Pawn(Coordinate coordinate, Player player) {
        super(coordinate, player);
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
            notifyPassingPawn(this);
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
    public List<Coordinate> getValidMovements() {
        validMovements.clear();
        validMovements.addAll(Stream
                .concat(specialGenerator.getMovements().stream(), basedGenerator.getMovements().stream()).toList());
        return validMovements;
    }

    @Override
    public boolean isMovementValid(Coordinate target) {
        return super.isMovementValid(target) || specialGenerator.isMovementValid(target);
    }

    @Override
    public void generateMovements() {
        super.generateMovements();
        specialGenerator.generateMovements();
    }

    public boolean isWhite() {
        return player == Player.WHITE;
    }

    public boolean isBlack() {
        return player == Player.BLACK;
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}
