package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.enums.CastlingSide;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.visitors.PieceInspector;
import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getKingMoveRulesBuilder;

import java.util.stream.Stream;

public class King extends Piece {

    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    public King(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getKingMoveRulesBuilder();
    }

    @Override
    public void put(Coordinate target) {
        if (!isMoved) {
            close();
        }
        super.put(target.copy());
    }

    @Override
    public void generateMovements() {
        this.movements = Stream
                .concat(
                        PieceInspector.getSpecialMovements(this).stream(),
                        movementBaseGenerator.generate(this).stream())
                .toList();
    }

    private void close() {
        isMoved = true;
    }

    public boolean isCastlingAvailable(CastlingSide side) {
        Coordinate target = new Coordinate(getCoordinate().row(), side.rookColumn);
        return isRookAvailableForCastling(target) && side.areSquaresClear(getCoordinate().row(), this);
    }

    public Coordinate getCastingCoordinate(CastlingSide side) {
        return new Coordinate(getCoordinate().row(), side.kingTargetColumn);
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}