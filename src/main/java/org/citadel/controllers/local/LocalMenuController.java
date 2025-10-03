package org.citadel.controllers.local;

import org.citadel.controllers.MenuController;
import org.citadel.controllers.OperationControllerVisitor;
import org.citadel.models.Game;

public class LocalMenuController extends LocalOperationController implements MenuController {

    public LocalMenuController(Game game) {
        super(game);
    }

    @Override
    public void startNewGame() {
        this.initialize();
    }

    @Override
    public void loadGame() {
        // Lógica para cargar un juego (pendiente)
        System.out.println("Funcionalidad no implementada");
    }

    @Override
    public void saveGame() {
        // Lógica para guardar un juego (pendiente)
        System.out.println("Funcionalidad no implementada");
    }

    @Override
    public void showHistory() {
        // Lógica para mostrar el historial (pendiente)
        System.out.println("Funcionalidad no implementada");
    }

    @Override
    public void exitGame() {
        this.exit();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        // Aún no tenemos un visitor para este controlador
    }
}
