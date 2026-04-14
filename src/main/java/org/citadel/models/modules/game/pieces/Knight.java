package org.citadel.models.modules.game.pieces;

import java.util.List;
import org.citadel.models.modules.game.pieces.enums.PieceSymbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.rules.GeneratorInspector;
import org.citadel.models.modules.game.pieces.rules.GeneratorMoveVisitor;

public class Knight extends Piece {

    public Knight(Coordinate coordinate, Player player) {
        super(coordinate, player);
    }

    @Override
    public List<Coordinate> generateMovements() {
        this.movements = GeneratorInspector.generatorMovements(this);
        return this.movements;
    }

    @Override
    public PieceSymbol getSymbol() {
        return PieceSymbol.KNIGHT;
    }

    @Override
    public void accept(GeneratorMoveVisitor generatorMoveVisitor) {
        generatorMoveVisitor.visit(this);
    }
}