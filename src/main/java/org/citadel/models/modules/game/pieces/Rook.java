package org.citadel.models.modules.game.pieces;

import java.util.List;
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
    public List<Coordinate> generateMovements() {
        this.movements = GeneratorInspector.generatorMovements(this);
        return this.movements;
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
    public void accept(GeneratorMoveVisitor generatorMoveVisitor) {
        generatorMoveVisitor.visit(this);
    }
}