package org.citadel.controllers.modules.game;

import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.Player;

public interface GameController extends OperationController {
    // Turno
    void switchTurn();

    void resetSelectedPiece();

    boolean isFinished();

    Player getCurrentPlayer();

    Player getRivalPlayer();

    int getIndexCurrentPlayer();

    // Selección y movimiento
    void selectPiece(Coordinate origin);

    void putPiece(Coordinate coordinate);

    void movePiece(Coordinate origin, Coordinate target);

    boolean isMovementValid(Coordinate target);

    List<Coordinate> getSelectedPieceMovements();

    // Consultas del tablero
    boolean isWithinBoardLimits(Coordinate coordinate);

    boolean isSquareOccupied(Coordinate coordinate);

    boolean isEmpty(Coordinate coordinate);

    boolean isPieceSelected(Coordinate coordinate);

    boolean isEnemy(Coordinate coordinate);

    boolean isJaque();

    String getPieceSymbol(Coordinate coordinate);

    // Pieza seleccionada
    boolean isKingSelected();

    boolean isPawnSelected();

    Coordinate getSelectedPieceCoordinate();

    List<Coordinate> getSelectedPieceEnPassantDiagonals();

    boolean isVulnerablePawnAt(Coordinate coordinate);

    boolean isTheWhitePieceSelected(Coordinate coordinate);

    boolean isTheBlackPieceSelected(Coordinate coordinate);

    // Captura
    void removeCurrentPlayerPiece(Coordinate coordinate);

    void removeRivalPlayerPiece(Coordinate coordinate);

    // Promoción
    boolean isThePawnPromoted();

    void promotePawn(String pieceType);

    void initialize();

    void begin();

    void end();

    void exit();
}
