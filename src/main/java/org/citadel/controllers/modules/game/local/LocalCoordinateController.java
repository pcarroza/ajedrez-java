package org.citadel.controllers.modules.game.local;

import org.citadel.models.pieces.Coordinate;

public abstract class LocalCoordinateController {

    public abstract Coordinate getTarget();

    public abstract Coordinate getOrigin();

}
