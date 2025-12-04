package org.citadel.controllers.local;

import org.citadel.models.pieces.Coordinate;

public class LocalRandomCoordinateController extends LocalCoordinateController {

    @Override
    public Coordinate getTarget() {
        throw new UnsupportedOperationException("Unimplemented method 'getTarget'");
    }

    @Override
    public Coordinate getOrigin() {
        throw new UnsupportedOperationException("Unimplemented method 'getOrigin'");
    }
}
