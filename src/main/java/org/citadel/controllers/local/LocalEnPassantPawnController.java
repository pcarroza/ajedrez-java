package org.citadel.controllers.local;

import org.citadel.models.Game;

public class LocalEnPassantPawnController extends LocalSpecialMovementsController {

    public LocalEnPassantPawnController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return false;
    }
}
