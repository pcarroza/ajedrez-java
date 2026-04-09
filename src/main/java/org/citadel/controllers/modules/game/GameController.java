package org.citadel.controllers.modules.game;

import java.util.List;

import org.citadel.models.modules.game.pieces.Coordinate;
import org.citadel.models.modules.game.pieces.enums.PieceSimbol;
import org.citadel.models.modules.game.pieces.enums.Player;
import org.citadel.models.modules.game.pieces.enums.PromotionType;

public interface GameController {
    // Turno
    void endTurn();

    void resetSelectedPiece();

    boolean isFinished();

    Player getCurrentPlayer();

    Player getRivalPlayer();

    int getIndexCurrentPlayer();

    // Selección y movimiento
    void selectPiece(Coordinate origin);

    void putPiece(Coordinate coordinate);

    void movePiece(Coordinate origin, Coordinate target);

    boolean canReach(Coordinate target);

    List<Coordinate> getSelectedPieceMovements();

    // Consultas del tablero
    boolean isWithinBoardLimits(Coordinate coordinate);

    boolean isOccupied(Coordinate coordinate);

    boolean isEmpty(Coordinate coordinate);

    boolean hasClaimed(Coordinate coordinate);

    boolean isRival(Coordinate coordinate);

    boolean isCheck();

    PieceSimbol getPieceSymbol(Coordinate coordinate);

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

    void promote(PromotionType promotionType);

    void initialize();

    void begin();

    void end();

    void exit();
}
