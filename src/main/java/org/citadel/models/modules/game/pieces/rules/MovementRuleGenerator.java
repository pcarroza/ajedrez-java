package org.citadel.models.modules.game.pieces.rules;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public interface MovementRuleGenerator {

    List<Coordinate> generate(Piece piece);
}