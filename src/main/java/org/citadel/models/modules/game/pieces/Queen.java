package org.citadel.models.modules.game.pieces;

import static org.citadel.models.modules.game.pieces.rules.MovementRulerFacade.getQueenMoveRulesBuilder;

import org.citadel.models.modules.game.pieces.enums.PieceSimbol;
import org.citadel.models.modules.game.pieces.enums.Player;

public class Queen extends Piece {

    public Queen(Coordinate coordinate, Player player) {
        super(coordinate, player);
        movementBaseGenerator = getQueenMoveRulesBuilder();
    }

    @Override
    public PieceSimbol getSymbol() {
        return PieceSimbol.QUEEN;
    }
}