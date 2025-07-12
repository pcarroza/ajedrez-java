package org.citadel;

import org.citadel.controllers.local.logic.LocalLogic;
import org.citadel.views.console.ConsoleView;

public class Standalone extends Chess {

    @Override
    public Logic getLogic() {
        return new LocalLogic();
    }

    @Override
    public View getView() {
        return new ConsoleView();
    }
}
