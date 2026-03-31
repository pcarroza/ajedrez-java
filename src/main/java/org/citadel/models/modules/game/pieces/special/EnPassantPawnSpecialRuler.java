package org.citadel.models.modules.game.pieces.special;

import java.util.ArrayList;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.enums.Player;

public class EnPassantPawnSpecialRuler extends SpecialMovesRuler {

    public EnPassantPawnSpecialRuler(Pawn pawn) {
        super(pawn);
    }

    @Override
    public void generateMovements() {
        movements = new ArrayList<>();
        Pawn pawn = (Pawn) piece;
        int row = pawn.getCoordinate().row();
        int expectedRow = (pawn.getPlayer() == Player.WHITE) ? 5 : 4;

        if (row == expectedRow) {
            checkVulnerability(pawn.getDiagonalLeft());
            checkVulnerability(pawn.getDiagonalRight());
        }
    }

    private void checkVulnerability(Coordinate diagonal) {
        if (ValidatorLimitsBoard.getInstance().isWithinLimits(diagonal)) {
            Coordinate rivalPawnCoord = new Coordinate(piece.getCoordinate().row(), diagonal.column());
            if (piece.isVulnerablePawnAt(rivalPawnCoord)) {
                movements.add(diagonal);
            }
        }
    }
}
