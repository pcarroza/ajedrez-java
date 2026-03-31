package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.pieces.Coordinate;

public abstract class LocalCoordinateController {

    public abstract Coordinate getTarget();

    public abstract Coordinate getOrigin();

}
