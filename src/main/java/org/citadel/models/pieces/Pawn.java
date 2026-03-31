package org.citadel.models.pieces;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.specialmovesrules.SpecialMovesRulesGenerator;
import org.citadel.models.pieces.visitors.PieceVisitor;
import org.citadel.models.pieces.specialmovesrules.EnPassantPawnSpecialRuleGenerator;

import static org.citadel.models.pieces.rules.MovementBaseGeneratorFacade.getPawnMoveRulesBuilder;

import java.util.List;
import java.util.stream.Stream;

public class Pawn extends Piece {

    private boolean initialState = true;

    private boolean isItPromoted = false;

    private boolean vulnerablePawn = false;

    private final SpecialMovesRulesGenerator specialGenerator;

    public Pawn(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getPawnMoveRulesBuilder();
        specialGenerator = new EnPassantPawnSpecialRuleGenerator(this);
    }

    @Override
    public void put(Coordinate target) {
        if (isInitialState()) {
            close();
        }
        if (inStep(target)) {
            vulnerablePawn = true;
            notifyEnPassantPawn(this);
        } else {
            vulnerablePawn = false;
            notifyDeleteEnPassantPawn(this);
        }
        if (isThePawnPromoted(target)) {
            changeToPromoted();
        }
        super.put(target.copy());
    }

    public boolean isPromoted() {
        return isItPromoted;
    }

    public boolean isVulnerable() {
        return vulnerablePawn;
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
        return validMovements.contains(target.copy());
    }

    @Override
    public void generateMovements() {
        specialGenerator.generateMovements();
        this.validMovements = Stream
                .concat(specialGenerator.getMovements().stream(), movementBaseGenerator.generate(this).stream()).toList();
    }

    public boolean canAdvanceOne() {
        return !isSquareOccupied(getForwardOne());
    }

    public boolean canAdvanceTwo() {
        return isInitialState() && !isSquareOccupied(getForwardOne()) && !isSquareOccupied(getForwardTwo());
    }

    public boolean canCaptureLeft() {
        return isEnemy(getDiagonalLeft());
    }

    public boolean canCaptureRight() {
        return isEnemy(getDiagonalRight());
    }

    public Coordinate getForwardOne() {
        int singleStep = 1;
        int direction = singleStep * player.getPlayer();
        return getDisplacedBy(new Coordinate(direction, 0));
    }

    public Coordinate getForwardTwo() {
        int doubleStep = 2;
        int direction = doubleStep * player.getPlayer();
        return getDisplacedBy(new Coordinate(direction, 0));
    }

    public Coordinate getDiagonalLeft() {
        int leftDiagonalOffset = -1;
        return getDisplacedBy(new Coordinate(player.getPlayer(), leftDiagonalOffset));
    }

    public Coordinate getDiagonalRight() {
        int rightDiagonalOffset = 1;
        return getDisplacedBy(new Coordinate(player.getPlayer(), rightDiagonalOffset));
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}