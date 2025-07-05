package org.citadel.controllers.local;

import org.citadel.models.pieces.Coordinate;

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
