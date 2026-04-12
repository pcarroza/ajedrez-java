package org.citadel.models.modules.game.pieces;

import org.citadel.models.modules.game.pieces.enums.PieceSymbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.rules.GeneratorInspector;
import org.citadel.models.modules.game.pieces.rules.GeneratorMoveVisitor;

public class Rook extends Piece {

    private boolean isMoved = false;

    public boolean isMoved() {
        return isMoved;
    }

    public Rook(Coordinate coordinate, Player player) {
        super(coordinate, player);
    }

    @Override
    public void generateMovements() {
        this.movements = GeneratorInspector.generatorMovements(this);
    }

    @Override
    public boolean isRook() {
        return true;
    }

    @Override
    public boolean isRookAvailableForCastling() {
        return !isMoved;
    }

    @Override
    public void put(Coordinate target) {
        if (!isMoved) {
            close();
        }
        super.put(target.copy());
    }

    private void close() {
        isMoved = true;
    }

    @Override
    public PieceSymbol getSymbol() {
        return PieceSymbol.ROOK;
    }

    @Override
    public void accept(GeneratorMoveVisitor visitor) {
        visitor.visit(this);
    }
}