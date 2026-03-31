package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.special.SpecialMovesRuler;
import org.citadel.models.modules.game.pieces.special.CastlingMoveRuler;
import org.citadel.models.modules.game.pieces.visitors.PieceVisitor;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getKingMoveRulesBuilder;

import java.util.stream.Stream;

public class King extends Piece {

    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    private final SpecialMovesRuler specialMovesRuler;

    public King(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getKingMoveRulesBuilder();
        specialMovesRuler = new CastlingMoveRuler(this);
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
        specialMovesRuler.generateMovements();
        this.validMovements = Stream
                .concat(specialMovesRuler.getMovements().stream(), movementBaseGenerator.generate(this).stream())
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