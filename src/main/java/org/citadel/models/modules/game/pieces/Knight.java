package org.citadel.models.modules.game.pieces;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getKnightMoveRulesBuilder;

import org.citadel.models.modules.game.pieces.enums.PieceSimbol;
import org.citadel.models.modules.game.pieces.enums.Player;

public class Knight extends Piece {

    public Knight(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getKnightMoveRulesBuilder();
    }

    @Override
    public PieceSimbol getSymbol() {
        return PieceSimbol.KNIGHT;
    }
}