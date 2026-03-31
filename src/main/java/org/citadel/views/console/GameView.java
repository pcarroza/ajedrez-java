package org.citadel.views.console;

import org.citadel.controllers.modules.game.PlacementController;
import org.citadel.controllers.modules.game.PlacementControllerVisitor;
import org.citadel.controllers.modules.game.PutPieceController;
import org.citadel.controllers.modules.game.SelectPieceController;
import org.citadel.models.modules.game.pieces.Coordinate;

public class GameView implements PlacementControllerVisitor {

    private final BoardView boardView;

    private final SpecialMovesView specialMovesView;

    private final PlacementCoordinateView placementCoordinateView;

    public GameView() {
        this.boardView = new BoardView();
        this.specialMovesView = new SpecialMovesView();
        this.placementCoordinateView = new PlacementCoordinateView();
    }

    @Override
    public void interact(PlacementController placementController) {
        placementController.accept(this);
    }

    @Override
    public void visit(SelectPieceController selectPieceController) {
        boardView.write(selectPieceController.getCurrentPlayer());
        boardView.write(selectPieceController);

        Coordinate origin;
        boolean isSelectPiece;
        do {
            origin = placementCoordinateView.getCoordinate("seleccionar una pieza");
            isSelectPiece = selectPieceController.isSelectPiece(origin);
            if (!isSelectPiece) {
                placementCoordinateView.showError("No hay una pieza en esa coordenada");
            }
        } while (!isSelectPiece);

        selectPieceController.select(origin);

        if (selectPieceController.hasSpecialMovements()) {
            specialMovesView.interact(selectPieceController.getSpecialMovements());
        }
    }

    @Override
    public void visit(PutPieceController putPieceController) {
        Coordinate target;
        boolean isMovementValid;
        do {
            target = placementCoordinateView.getCoordinate("mover la pieza seleccionada");
            isMovementValid = putPieceController.isMovementValid(target);
            if (!isMovementValid) {
                placementCoordinateView.showError("Movimiento inválido");
            }
        } while (!isMovementValid);

        putPieceController.put(target);
        boardView.write(putPieceController);
    }
}
