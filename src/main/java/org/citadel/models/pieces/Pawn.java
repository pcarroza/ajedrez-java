package org.citadel.models.pieces;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.pieces.specialmovesrules.SpecialMovesRulesGenerator;
import org.citadel.models.pieces.specialmovesrules.EnPassantPawnSpecialRuleGenerator;

import java.util.List;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createPawnMoveRulesBuilder;

public class Pawn extends Piece {

    int SINGLE_STEP = 1;
    int DOUBLE_STEP = 2;
    int LEFT_DIAGONAL_OFFSET = -1;
    int RIGHT_DIAGONAL_OFFSET = 1;

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
            notifyEnPassantPawn(this);
        } else {
            notifyDeleteEnPassantPawn(this);
            vulnerablePawn = false;
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

    public boolean canAdvanceOne() {
        return false;
    }

    public boolean canAdvanceTwo() {
        return false;
    }

    public boolean canCaptureLeft() {
        return false;
    }

    public boolean canCaptureRight() {
        return false;
    }

    public Coordinate getForwardOne() {
        int direction = SINGLE_STEP * player.getPlayer();
        return getDisplacedBy(new Coordinate(direction, 0));
    }

    public Coordinate getForwardTwo() {
        int direction = DOUBLE_STEP * player.getPlayer();
        return  getDisplacedBy(new Coordinate(direction, 0));
    }

    public Coordinate getDiagonalLeft() {
        return  getDisplacedBy(new Coordinate(player.getPlayer(), LEFT_DIAGONAL_OFFSET));
    }

    public Coordinate getDiagonalRight() {
        return  getDisplacedBy(new Coordinate(player.getPlayer(), RIGHT_DIAGONAL_OFFSET));
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
