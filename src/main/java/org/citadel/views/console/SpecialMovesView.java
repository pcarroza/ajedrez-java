package org.citadel.views.console;

import org.citadel.common.tools.Terminal;
import org.citadel.controllers.CastlingMovesController;
import org.citadel.controllers.EnPassantPawnController;
import org.citadel.controllers.PromotionPawnController;
import org.citadel.controllers.SpecialMovementsControllerVisitor;
import org.citadel.controllers.local.LocalSpecialMovementsController;
import org.citadel.models.pieces.Coordinate;

import java.util.List;

public class SpecialMovesView implements SpecialMovementsControllerVisitor {

    public void interact(List<LocalSpecialMovementsController> controllers) {
        if (controllers.isEmpty()) {
            return;
        }

        Terminal.writeln("Movimientos especiales disponibles:");
        for (int i = 0; i < controllers.size(); i++) {
            Terminal.writeln((i + 1) + ". " + controllers.get(i).getName());
        }
        Terminal.writeln("0. Ninguno");

        int option = Terminal.readInt("Elige una opción: ");

        if (option > 0 && option <= controllers.size()) {
            controllers.get(option - 1).accept(this);
        }
    }

    @Override
    public void visit(CastlingMovesController controller) {
        Terminal.writeln("Has elegido Enroque.");
        List<Coordinate> rooks = controller.getAvailableRooks();
        Terminal.writeln("TODO: Implementar la selección de la torre.");
    }

    @Override
    public void visit(EnPassantPawnController controller) {
        Terminal.writeln("Has elegido Captura al Paso.");
        boolean confirm = Terminal.readString("¿Confirmar? (s/n): ").equalsIgnoreCase("s");
        if (confirm) {
            controller.capture();
        }
    }

    @Override
    public void visit(PromotionPawnController controller) {
        Terminal.writeln("Has elegido Promoción de Peón.");
        String pieceType = Terminal.readString("Elige pieza (Q, R, B, K): ");
        controller.promote(pieceType);
    }
}