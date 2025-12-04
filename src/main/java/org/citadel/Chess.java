package org.citadel;

import org.citadel.controllers.OperationController;

public abstract class Chess {

    private final Logic logic;

    private final View view;

    Chess() {
        this.logic = getLogic();
        this.view = getView();
    }

    public abstract Logic getLogic();

    public abstract View getView();

    public void run() {
        OperationController controller;
        do {
            controller = logic.getController();
            if (controller != null) {
                view.interact(controller);
            }
        } while (controller != null);
    }
}
