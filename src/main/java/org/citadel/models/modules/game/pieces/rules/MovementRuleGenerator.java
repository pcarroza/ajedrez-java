package org.citadel.models.modules.game.pieces.rules;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public interface MovementRuleGenerator<T extends Piece> {

    List<Coordinate> generate(T piece);
}