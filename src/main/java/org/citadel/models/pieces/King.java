package org.citadel.models.pieces;

import org.citadel.models.pieces.specialmovesrules.SpecialMoveRule;
import org.citadel.models.pieces.specialmovesrules.SpecialRuleCastlingMove;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.FacadeMotionManager.createKingMoveRulesManager;

public class King extends Piece {

    private boolean isMoved = false;

    private final SpecialMoveRule specialMoveRule;


    public King(Coordinate coordinate, Color color) {
        super(coordinate, color);
        moveRulesManager = createKingMoveRulesManager(this);
        specialMoveRule = new SpecialRuleCastlingMove(this);
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
        return super.isMovementValid(target) || specialMoveRule.isMovementValid(target);
    }

    @Override
    public void buildMovements() {
        super.buildMovements();
        specialMoveRule.buildMovements();
        validMovements = new ArrayList<>();
        validMovements = Stream
                .concat(specialMoveRule.getMovements().stream(), moveRulesManager.getMovements().stream()).toList();
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
