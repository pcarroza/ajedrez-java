package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.visitors.PieceInspector;
import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;
import org.citadel.models.modules.game.pieces.visitors.SpecialMovesVisitor;
import org.citadel.models.modules.game.pieces.enums.Player;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getPawnMoveRulesBuilder;

import java.util.stream.Stream;

public class Pawn extends Piece {

    private boolean initialState = true;

    private boolean isItPromoted = false;

    private boolean vulnerablePawn = false;

    public Pawn(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getPawnMoveRulesBuilder();
    }

    public Player getPlayer() {
        return player;
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

    public boolean isOnEnPassantRow() {
        final int IN_STEP_ROW_WHITE = 5;
        final int IN_STEP_ROW_BLACK = 4;
        int expectedRow = getPlayer() == Player.WHITE ? IN_STEP_ROW_WHITE : IN_STEP_ROW_BLACK;
        return getCoordinate().row() == expectedRow;
    }

    public boolean hasVulnerableRivalPawnBeside(Coordinate diagonal) {
        Coordinate rivalCoordinate = new Coordinate(getCoordinate().row(), diagonal.column());
        return isVulnerablePawnAt(rivalCoordinate);
    }

    private boolean inStep(Coordinate target) {
        return getForwardTwo().equals(target);
    }

    private boolean isThePawnPromoted(Coordinate coordinate) {
        int targetRow = player == Player.WHITE ? 8 : 1;
        return coordinate.row() == targetRow;
    }

    private void changeToPromoted() {
        isItPromoted = true;
    }

    @Override
    public boolean isMovementValid(Coordinate target) {
        return movements.contains(target.copy());
    }

    @Override
    public void generateMovements() {
        this.movements = Stream
                .concat(
                        PieceInspector.getSpecialMovements(this).stream(),
                        movementBaseGenerator.generate(this).stream())
                .toList();
    }

    public boolean canAdvanceOne() {
        return !isOccupied(getForwardOne());
    }

    public boolean canAdvanceTwo() {
        return isInitialState() && !isOccupied(getForwardOne()) && !isOccupied(getForwardTwo());
    }

    public boolean canCaptureLeft() {
        return isRival(getDiagonalLeft());
    }

    public boolean canCaptureRight() {
        return isRival(getDiagonalRight());
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