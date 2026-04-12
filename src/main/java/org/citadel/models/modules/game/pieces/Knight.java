package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.enums.PieceSymbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.rules.GeneratorInspector;
import org.citadel.models.modules.game.pieces.rules.GeneratorMoveVisitor;

public class Knight extends Piece {

    public Knight(Coordinate coordinate, Player player) {
        super(coordinate, player);
    }

    @Override
    public void generateMovements() {
        this.movements = GeneratorInspector.generatorMovements(this);
    }

    @Override
    public PieceSymbol getSymbol() {
        return PieceSymbol.KNIGHT;
    }

    @Override
    public void accept(GeneratorMoveVisitor visitor) {
        visitor.visit(this);
    }
}