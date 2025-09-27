package org.citadel.controllers.local;

import org.citadel.models.Game;

import java.util.ArrayList;
import java.util.List;

public class LocalSpecialMovementsControllerComposite implements LocalSpecialMovementsControllerComponent {

    private final List<LocalSpecialMovementsControllerComponent> components;

    private final List<LocalSpecialMovementsController> applicableControllers;

    LocalSpecialMovementsControllerComposite(Game game) {
        components = new ArrayList<>();
        applicableControllers = new ArrayList<>();
        components.add(new LocalCastlingMovesController(game));
        components.add(new LocalEnPassantPawnController(game));
        components.add(new LocalPromotionController(game));
    }

    @Override
    public boolean isApplicable() {
        applicableControllers.clear();
        for (LocalSpecialMovementsControllerComponent component : components) {
            if (component.isApplicable()) {
                applicableControllers.add(component.getSpecialMoveController());
            }
        }
        return !applicableControllers.isEmpty();
    }

    @Override
    public LocalSpecialMovementsController getSpecialMoveController() {
        assert !applicableControllers.isEmpty();
        return applicableControllers.get(0);
    }

    public List<LocalSpecialMovementsController> getApplicableControllers() {
        return applicableControllers;
    }
}
