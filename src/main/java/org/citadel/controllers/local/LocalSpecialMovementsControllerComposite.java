package org.citadel.controllers.local;

import org.citadel.models.Game;

import java.util.ArrayList;
import java.util.List;

public class LocalSpecialMovementsControllerComposite implements LocalSpecialMovementsControllerComponent {

    private List<LocalSpecialMovementsControllerComponent> components;

    LocalSpecialMovementsControllerComposite(Game game) {
        components = new ArrayList<>();
        components.add(new LocalCastlingMovesController(game));
        components.add(new LocalEnPassantPawnController(game));
        components.add(new LocalPromotionController(game));
    }


    @Override
    public void execute() {

    }
}

