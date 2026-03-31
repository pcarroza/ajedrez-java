package org.citadel.controllers.modules.game.local;

import org.citadel.models.modules.game.pieces.Coordinate;

public class LocalUserCoordinateController extends LocalCoordinateController {

    @Override
    public Coordinate getTarget() {
        return new Coordinate();
    }

    @Override
    public Coordinate getOrigin() {
        return new Coordinate();
    }
}
