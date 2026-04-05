package org.citadel.models.modules.game.pieces.rules;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.Piece;

import java.util.List;

public abstract class MovementRuleGenerator {

    public abstract List<Coordinate> generate(Piece piece);
}