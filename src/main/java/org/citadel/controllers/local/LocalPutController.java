package org.citadel.controllers.local;

import org.citadel.common.validators.ValidatorLimitsBoard;
import org.citadel.models.Game;
import org.citadel.models.pieces.Coordinate;

public class LocalPutController extends LocalController {

    public LocalPutController(Game game) {
        super(game);
    }

    @Override
    public void put(Coordinate coordinate) {
        assert coordinate != null;
        assert ValidatorLimitsBoard.getInstance().isWithinLimits(coordinate);
        super.put(coordinate);
    }
}
