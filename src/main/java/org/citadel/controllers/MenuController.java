package org.citadel.controllers;

public interface MenuController extends OperationController {
    void startNewGame();

    void loadGame();

    void saveGame();

    void showHistory();

    void exitGame();
}