package org.citadel.views.console;

import org.citadel.controllers.CoordinateControllerVisitor;
import org.citadel.controllers.RandomCoordinateController;
import org.citadel.controllers.UserCoordinateController;

public class PlacementCoordinateView implements CoordinateControllerVisitor {

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'visit'");
    }
}
