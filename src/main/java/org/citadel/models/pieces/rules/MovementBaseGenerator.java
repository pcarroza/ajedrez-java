package org.citadel.models.pieces.rules;

import org.citadel.models.pieces.Coordinate;
import org.citadel.models.pieces.Piece;

import java.util.List;

public abstract class MovementBaseGenerator {

    public abstract List<Coordinate> generate(Piece piece);
}