package org.citadel.controllers.local;

import org.citadel.models.Game;

import java.util.ArrayList;
import java.util.List;

public class LocalSpecialMovementsControllerFactory {

    private final List<LocalSpecialMovementsController> specialControllers;

    private final List<LocalSpecialMovementsController> applicableControllers;

    LocalSpecialMovementsControllerFactory(Game game) {
        specialControllers = new ArrayList<>();
        specialControllers.add(new LocalCastlingMovesController(game));
        specialControllers.add(new LocalEnPassantPawnController(game));
        specialControllers.add(new LocalPromotionController(game));
        applicableControllers = new ArrayList<>();
    }

    public boolean isApplicable() {
        applicableControllers.clear();
        for (LocalSpecialMovementsController specialController : specialControllers) {
            if (specialController.isApplicable()) {
                applicableControllers.add(specialController.getSpecialMoveController());
            }
        }
        return !applicableControllers.isEmpty();
    }

    public List<LocalSpecialMovementsController> getApplicableControllers() {
        return applicableControllers;
    }
}
