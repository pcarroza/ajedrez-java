package org.citadel.models.modules.game.pieces.rules;

import org.citadel.models.modules.game.pieces.Bishop;
import org.citadel.models.modules.game.pieces.King;
import org.citadel.models.modules.game.pieces.Knight;
import org.citadel.models.modules.game.pieces.Pawn;
import org.citadel.models.modules.game.pieces.Queen;
import org.citadel.models.modules.game.pieces.Rook;

public interface GeneratorMoveVisitor {

    void visit(Pawn pawn);

    void visit(Rook rook);

    void visit(Knight knight);

    void visit(Bishop bishop);

    void visit(Queen queen);

    void visit(King king);
}
