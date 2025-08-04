package org.citadel.models.pieces;

import org.citadel.models.pieces.specialmovesrules.SpecialMoveRulesBuilder;
import org.citadel.models.pieces.specialmovesrules.SpecialRuleCastlingMove;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.MovementBuilderFacade.createKingMoveRulesBuilder;

public class King extends Piece {

    private boolean isMoved = false;

    private final SpecialMoveRulesBuilder specialMoveRulesBuilder;


    public King(Coordinate coordinate, Color color) {
        super(coordinate, color);
        movementRuleBuilder = createKingMoveRulesBuilder(this);
        specialMoveRulesBuilder = new SpecialRuleCastlingMove(this);
    }

    @Override
    public void put(Coordinate target) {
        if (isNotMoved()) {
            close();
        }
        super.put(target.copy());
    }

    @Override
    public boolean isMovementValid(Coordinate target) {
        return super.isMovementValid(target) || specialMoveRulesBuilder.isMovementValid(target);
    }

    @Override
    public void buildMovements() {
        super.buildMovements();
        specialMoveRulesBuilder.buildMovements();
        validMovements = new ArrayList<>();
        validMovements = Stream
                .concat(specialMoveRulesBuilder.getMovements().stream(), movementRuleBuilder.getMovements().stream()).toList();
    }

    @Override
    public boolean isNotMoved() {
        return !isMoved;
    }

    private void close() {
        isMoved = true;
    }

    @Override
    public boolean isKing() {
        return true;
    }
}
