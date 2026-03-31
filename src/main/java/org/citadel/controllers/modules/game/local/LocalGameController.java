package org.citadel.controllers.modules.game.local;

import org.citadel.controllers.modules.game.local.logic.GameState;
import org.citadel.controllers.modules.game.GameController;
import org.citadel.controllers.modules.game.OperationControllerVisitor;
import org.citadel.models.modules.game.Game;

public class LocalGameController extends LocalOperationController implements GameController {

    public LocalGameController(Game game) {
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

    @Override
    public GameState getGameState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameState'");
    }

    @Override
    public boolean isGameInProgress() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isGameInProgress'");
    }
}
