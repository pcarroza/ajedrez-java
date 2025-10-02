package org.citadel.controllers.local.logic;

import org.citadel.Logic;
import org.citadel.controllers.OperationController;
import org.citadel.controllers.local.LocalOperationControllerBuilder;
import org.citadel.models.Game;
import org.citadel.models.Observer;

public class LocalLogic implements Logic, Observer {

    private State actualState;

    public LocalLogic() {
        Game game = new Game(this);
        LocalOperationControllerBuilder builder = new LocalOperationControllerBuilder(game);
        builder.build();
        actualState = new StatesBuilder(builder).getInitialState();
    }

    @Override
    public void initialize() {
        actualState = actualState.initialize();
    }

    @Override
    public void begin() {
        actualState = actualState.begin();
    }

    @Override
    public void end() {
        actualState = actualState.end();
    }

    @Override
    public void exit() {
        actualState = actualState.exit();
    }

    @Override
    public OperationController getController() {
        return actualState.getController();
    }
}
