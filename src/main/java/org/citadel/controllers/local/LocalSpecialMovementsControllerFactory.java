package org.citadel.controllers.local;

import org.citadel.models.Game;

import java.util.ArrayList;
import java.util.List;

public class LocalSpecialMovementsControllerFactory {

    private final List<LocalSpecialMovementsController> controllers;

    private final List<LocalSpecialMovementsController> applicableControllers;

    LocalSpecialMovementsControllerFactory(Game game) {
        controllers = new ArrayList<>();
        controllers.add(new LocalCastlingMovesController(game));
        controllers.add(new LocalEnPassantPawnController(game));
        controllers.add(new LocalPromotionController(game));
        applicableControllers = new ArrayList<>();
    }

    public boolean isApplicable() {
        applicableControllers.clear();
        for (LocalSpecialMovementsController component : controllers) {
            if (component.isApplicable()) {
                applicableControllers.add(component.getSpecialMoveController());
            }
        }
        return !applicableControllers.isEmpty();
    }

    public List<LocalSpecialMovementsController> getApplicableControllers() {
        return applicableControllers;
    }
}
