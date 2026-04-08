package org.citadel.models.modules.game.pieces.special;

import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;

public abstract class SpecialMoveGenerator<T> {

    public abstract List<Coordinate> generator(T piece);
}
