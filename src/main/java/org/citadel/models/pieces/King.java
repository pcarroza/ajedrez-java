package org.citadel.models.pieces;

import org.citadel.models.pieces.specialmovesrules.SpecialMovesRulesGenerator;
import org.citadel.models.pieces.specialmovesrules.SpecialRuleCastlingMoves;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createKingMoveRulesBuilder;

public class King extends Piece {

    private boolean isMoved = false;

    private final SpecialMovesRulesGenerator specialMoveRulesBuilder;


    public King(Coordinate coordinate, Color color) {
        super(coordinate, color);
        basedGenerator = createKingMoveRulesBuilder(this);
        specialMoveRulesBuilder = new SpecialRuleCastlingMoves(this);
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
    public void generateMovements() {
        super.generateMovements();
        specialMoveRulesBuilder.generateMovements();
        validMovements = new ArrayList<>();
        validMovements = Stream
                .concat(specialMoveRulesBuilder.getMovements().stream(), basedGenerator.getMovements().stream()).toList();
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
