package org.citadel.views.console;

public class GameView {

    private StartView startView;

    private BoardView boardView;

    private ContinueView continueView;

    public GameView(BoardView boardView) {
        startView = new StartView();
        boardView = new BoardView();
        continueView = new ContinueView();
    }

    public void interact() {
    }

    public void visit() {
    }
}
