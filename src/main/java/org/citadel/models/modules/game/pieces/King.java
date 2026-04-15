package org.citadel.models.modules.game.pieces;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.citadel.models.modules.game.pieces.enums.CastlingSide;
import org.citadel.models.modules.game.pieces.enums.PieceSymbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.rules.GeneratorInspector;
import org.citadel.models.modules.game.pieces.rules.GeneratorMoveVisitor;
import org.citadel.models.modules.game.pieces.special.CastingMoveGenerator;

public class King extends Piece {

    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    public King(Coordinate coordinate, Player player) {
        super(coordinate, player);
    }

    @Override
    public void put(Coordinate target) {
        if (!isMoved) {
            close();
        }
        super.put(target.copy());
    }

    @Override
    public List<Coordinate> generateMovements() {
        var castingMoves = CastingMoveGenerator.getInstance().generator(this).stream();
        var inspectedMoves = GeneratorInspector.generatorMovements(this).stream();
        this.movements = Stream.concat(castingMoves, inspectedMoves).toList();
        return this.movements;
    }

    private void close() {
        isMoved = true;
    }

    public boolean isDynamicallyValid(CastlingSide side) {
        if (isKingInCheck())
            return false;
        Coordinate kingTarget = getCastingCoordinate(side);
        List<Coordinate> squaresToVerify = new ArrayList<>(side.getSquaresKingPassesThrough(getCoordinate()));
        squaresToVerify.add(0, getCoordinate());
        squaresToVerify.add(kingTarget);
        return squaresToVerify.stream().noneMatch(it -> isSquareAttackedBy(it));
    }

    public boolean isStructurallyValid(CastlingSide side) {
        int row = getCoordinate().row();
        Coordinate rookCoordinate = new Coordinate(row, side.rookColumn);
        return isRookAvailableForCastling(rookCoordinate) && side.areSquaresClear(row, this);
    }

    public Coordinate getCastingCoordinate(CastlingSide side) {
        return new Coordinate(getCoordinate().row(), side.kingTargetColumn);
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public PieceSymbol getSymbol() {
        return PieceSymbol.KING;
    }

    @Override
    public void accept(GeneratorMoveVisitor generatorMoveVisitor) {
        generatorMoveVisitor.visit(this);
    }
}