package org.citadel.models.pieces;

import org.citadel.models.pieces.specialmovesrules.SpecialMovesRulesGenerator;
import org.citadel.models.pieces.specialmovesrules.SpecialRuleCastlingMoves;

import java.util.List;
import java.util.stream.Stream;

import static org.citadel.models.pieces.rulesofmovements.MovementRulesBaseGeneratorFacade.createKingMoveRulesBuilder;

public class King extends Piece {

    private boolean isMoved = false;

    private final SpecialMovesRulesGenerator specialGenerator;

    public King(Coordinate coordinate, Player player) {
        super(coordinate, player);
        basedGenerator = createKingMoveRulesBuilder(this);
        specialGenerator = new SpecialRuleCastlingMoves(this);
    }

    @Override
    public void put(Coordinate target) {
        if (!isMoved) {
            close();
        }
        super.put(target.copy());
    }

    @Override
    public boolean isMovementValid(Coordinate target) {
        return super.isMovementValid(target) || specialGenerator.isMovementValid(target);
    }

    @Override
    public List<Coordinate> getValidMovements() {
        validMovements.clear();
        validMovements.addAll(Stream
                .concat(specialGenerator.getMovements().stream(), basedGenerator.getMovements().stream()).toList());
        return validMovements;
    }

    @Override
    public void generateMovements() {
        super.generateMovements();
        specialGenerator.generateMovements();
    }

    private void close() {
        isMoved = true;
    }

    @Override
    public void accept(PieceVisitor visitor) {
        visitor.visit(this);
    }
}
