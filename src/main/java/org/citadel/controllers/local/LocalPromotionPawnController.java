package org.citadel.controllers.local;

import org.citadel.controllers.PromotionPawnController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.models.Game;

public class LocalPromotionPawnController extends LocalSpecialMovementsController implements PromotionPawnController {

    public LocalPromotionPawnController(Game game) {
        super(game);
    }

    @Override
    public boolean isApplicable() {
        return false;
    }

    @Override
    public String getName() {
        return "Promoción de Peón";
    }

    @Override
    public void accept(SpecialMovementsControllerVisitor specialMovementsControllerVisitor) {
        specialMovementsControllerVisitor.visit(this);
    }

    @Override
    public void promote(String pieceType) {
        // TODO: Implementar lógica
    }
}
