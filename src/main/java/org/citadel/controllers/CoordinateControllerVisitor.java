package org.citadel.controllers;

public interface CoordinateControllerVisitor {

    void visit(UserCoordinateController userCoordinateController);

    void visit(RandomCoordinateController randomCoordinateController);
}
