package org.citadel.models.pieces;

import org.citadel.models.pieces.enums.Player;
import org.citadel.models.pieces.specialmovesrules.SpecialMovesRulesGenerator;
import org.citadel.models.pieces.specialmovesrules.SpecialRuleCastlingMoves;
import org.citadel.models.pieces.visitors.PieceVisitor;

import static org.citadel.models.pieces.rules.MovementBaseGeneratorFacade.getKingMoveRulesBuilder;

import java.util.stream.Stream;

public class King extends Piece {

    private boolean isMoved = false;

    private final SpecialMovesRulesGenerator specialGenerator;

    public King(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getKingMoveRulesBuilder();
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
    public void generateMovements() {
        specialGenerator.generateMovements();
        this.validMovements = Stream
                .concat(specialGenerator.getMovements().stream(), movementBaseGenerator.generate(this).stream())
                .toList();
    }

    private void close() {
        isMoved = true;
    }

    @Override
    public void accept(PieceVisitor pieceVisitor) {
        pieceVisitor.visit(this);
    }
}