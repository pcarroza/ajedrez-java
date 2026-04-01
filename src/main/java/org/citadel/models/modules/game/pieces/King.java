package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.special.SpecialRulesGenerator;
import org.citadel.models.modules.game.pieces.special.CastlingMoveRulerGenerator;
import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getKingMoveRulesBuilder;

import java.util.stream.Stream;

public class King extends Piece {

    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    private final SpecialRulesGenerator specialRulesGenerator;

    public King(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getKingMoveRulesBuilder();
        specialRulesGenerator = new CastlingMoveRulerGenerator(this);
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
        specialRulesGenerator.generate();
        this.validMovements = Stream
                .concat(specialRulesGenerator.getMovements().stream(), movementBaseGenerator.generate(this).stream())
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